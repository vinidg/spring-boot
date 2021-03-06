package br.com.vinicius.springboot.service;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import br.com.vinicius.springboot.domain.Categoria;
import br.com.vinicius.springboot.domain.Produto;
import br.com.vinicius.springboot.enums.Perfil;
import br.com.vinicius.springboot.execeptions.AuthorizationException;
import br.com.vinicius.springboot.repositories.CategoriaRepository;
import br.com.vinicius.springboot.repositories.ProdutoRepository;
import br.com.vinicius.springboot.security.UserSS;
import br.com.vinicius.springboot.service.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private S3Service s3Service;
	
	@Value("${img.prefix.product.profile}")
	private String prefix;
	
	@Value("${img.profile.size}")
	private Integer size;
	

	public Produto find(String id) {
		
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));	
	}
	
	public Page<Produto> findByCategorias(List<String> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = (List<Categoria>) categoriaRepo.findAllById(ids);
		Page<Produto> list = null;
		if(categorias.isEmpty()) {
			list = repo.findAll(pageRequest);
		}else {
			list = repo.findByCategoriasIn(categorias, pageRequest);
		}
		return list;
	}
	
	@Transactional
	public Produto insert(Produto obj) {
		obj = repo.save(obj);
		return obj;
	}
	
	public URI uploadProductPicture(MultipartFile multipartFile, String idProduto) {
		
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN)) {
			throw new AuthorizationException("Acesso negado");
		}
		
		BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
//		jpgImage = imageService.resize(jpgImage, size);
		
		String fileName = prefix + idProduto + ".jpg";
		
		uploadProductPictureSmall(jpgImage, idProduto);
		
		return s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), "produtos", fileName, "image");
		
	}
	
	public void uploadProductPictureSmall(BufferedImage image, String idProduto) {
		image = imageService.resize(image, size);
		
		String fileName = prefix + idProduto + "-small" + ".jpg";
		
		s3Service.uploadFile(imageService.getInputStream(image, "jpg"), "produtos", fileName, "image");
	}
	
	public Produto update(Produto produto) {
		Produto produtoUpdate = find(produto.getId());
		return repo.save(produtoUpdate);
		
	}
	
}
