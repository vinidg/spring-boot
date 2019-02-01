package br.com.vinicius.springboot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.vinicius.springboot.domain.Categoria;
import br.com.vinicius.springboot.domain.Cliente;
import br.com.vinicius.springboot.domain.EstadoCidade;
import br.com.vinicius.springboot.enums.Perfil;
import br.com.vinicius.springboot.repositories.CategoriaRepository;
import br.com.vinicius.springboot.repositories.ClienteRepository;
import br.com.vinicius.springboot.repositories.EstadoCidadeRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepositorio;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private EstadoCidadeRepository estadoCidadeRepository;

	@Override
	public void run(String... args) throws Exception {

		clienteRepositorio.deleteAll();
		categoriaRepository.deleteAll();
		estadoCidadeRepository.deleteAll();
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));

		Cliente cliente1 = new Cliente();
		cliente1.setId(null);
		cliente1.setNome("Maria das Graças");
		cliente1.setCpf("54417644144");
		cliente1.setRg("412425678");
		cliente1.setDataNascimento("10-05-2000");
		cliente1.setPass(encoder.encode("1234567"));
		cliente1.setUser("maria");

		cliente1.addPerfil(Perfil.ADMIN);
		clienteRepositorio.saveAll(Arrays.asList(cliente1));
		

		String json_estados_cidades = "[{\r\n" + 
				"    \"sigla\": \"AC\",\r\n" + 
				"    \"nome\": \"Acre\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Acrelândia\",\r\n" + 
				"      \"Assis Brasil\",\r\n" + 
				"      \"Brasiléia\",\r\n" + 
				"      \"Bujari\",\r\n" + 
				"      \"Capixaba\",\r\n" + 
				"      \"Cruzeiro do Sul\",\r\n" + 
				"      \"Epitaciolândia\",\r\n" + 
				"      \"Feijó\",\r\n" + 
				"      \"Jordão\",\r\n" + 
				"      \"Mâncio Lima\",\r\n" + 
				"      \"Manoel Urbano\",\r\n" + 
				"      \"Marechal Thaumaturgo\",\r\n" + 
				"      \"Plácido de Castro\",\r\n" + 
				"      \"Porto Acre\",\r\n" + 
				"      \"Porto Walter\",\r\n" + 
				"      \"Rio Branco\",\r\n" + 
				"      \"Rodrigues Alves\",\r\n" + 
				"      \"Santa Rosa do Purus\",\r\n" + 
				"      \"Sena Madureira\",\r\n" + 
				"      \"Senador Guiomard\",\r\n" + 
				"      \"Tarauacá\",\r\n" + 
				"      \"Xapuri\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"AL\",\r\n" + 
				"    \"nome\": \"Alagoas\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Água Branca\",\r\n" + 
				"      \"Anadia\",\r\n" + 
				"      \"Arapiraca\",\r\n" + 
				"      \"Atalaia\",\r\n" + 
				"      \"Barra de Santo Antônio\",\r\n" + 
				"      \"Barra de São Miguel\",\r\n" + 
				"      \"Batalha\",\r\n" + 
				"      \"Belém\",\r\n" + 
				"      \"Belo Monte\",\r\n" + 
				"      \"Boca da Mata\",\r\n" + 
				"      \"Branquinha\",\r\n" + 
				"      \"Cacimbinhas\",\r\n" + 
				"      \"Cajueiro\",\r\n" + 
				"      \"Campestre\",\r\n" + 
				"      \"Campo Alegre\",\r\n" + 
				"      \"Campo Grande\",\r\n" + 
				"      \"Canapi\",\r\n" + 
				"      \"Capela\",\r\n" + 
				"      \"Carneiros\",\r\n" + 
				"      \"Chã Preta\",\r\n" + 
				"      \"Coité do Nóia\",\r\n" + 
				"      \"Colônia Leopoldina\",\r\n" + 
				"      \"Coqueiro Seco\",\r\n" + 
				"      \"Coruripe\",\r\n" + 
				"      \"Craíbas\",\r\n" + 
				"      \"Delmiro Gouveia\",\r\n" + 
				"      \"Dois Riachos\",\r\n" + 
				"      \"Estrela de Alagoas\",\r\n" + 
				"      \"Feira Grande\",\r\n" + 
				"      \"Feliz Deserto\",\r\n" + 
				"      \"Flexeiras\",\r\n" + 
				"      \"Girau do Ponciano\",\r\n" + 
				"      \"Ibateguara\",\r\n" + 
				"      \"Igaci\",\r\n" + 
				"      \"Igreja Nova\",\r\n" + 
				"      \"Inhapi\",\r\n" + 
				"      \"Jacaré dos Homens\",\r\n" + 
				"      \"Jacuípe\",\r\n" + 
				"      \"Japaratinga\",\r\n" + 
				"      \"Jaramataia\",\r\n" + 
				"      \"Jequiá da Praia\",\r\n" + 
				"      \"Joaquim Gomes\",\r\n" + 
				"      \"Jundiá\",\r\n" + 
				"      \"Junqueiro\",\r\n" + 
				"      \"Lagoa da Canoa\",\r\n" + 
				"      \"Limoeiro de Anadia\",\r\n" + 
				"      \"Maceió\",\r\n" + 
				"      \"Major Isidoro\",\r\n" + 
				"      \"Mar Vermelho\",\r\n" + 
				"      \"Maragogi\",\r\n" + 
				"      \"Maravilha\",\r\n" + 
				"      \"Marechal Deodoro\",\r\n" + 
				"      \"Maribondo\",\r\n" + 
				"      \"Mata Grande\",\r\n" + 
				"      \"Matriz de Camaragibe\",\r\n" + 
				"      \"Messias\",\r\n" + 
				"      \"Minador do Negrão\",\r\n" + 
				"      \"Monteirópolis\",\r\n" + 
				"      \"Murici\",\r\n" + 
				"      \"Novo Lino\",\r\n" + 
				"      \"Olho d'Água das Flores\",\r\n" + 
				"      \"Olho d'Água do Casado\",\r\n" + 
				"      \"Olho d'Água Grande\",\r\n" + 
				"      \"Olivença\",\r\n" + 
				"      \"Ouro Branco\",\r\n" + 
				"      \"Palestina\",\r\n" + 
				"      \"Palmeira dos Índios\",\r\n" + 
				"      \"Pão de Açúcar\",\r\n" + 
				"      \"Pariconha\",\r\n" + 
				"      \"Paripueira\",\r\n" + 
				"      \"Passo de Camaragibe\",\r\n" + 
				"      \"Paulo Jacinto\",\r\n" + 
				"      \"Penedo\",\r\n" + 
				"      \"Piaçabuçu\",\r\n" + 
				"      \"Pilar\",\r\n" + 
				"      \"Pindoba\",\r\n" + 
				"      \"Piranhas\",\r\n" + 
				"      \"Poço das Trincheiras\",\r\n" + 
				"      \"Porto Calvo\",\r\n" + 
				"      \"Porto de Pedras\",\r\n" + 
				"      \"Porto Real do Colégio\",\r\n" + 
				"      \"Quebrangulo\",\r\n" + 
				"      \"Rio Largo\",\r\n" + 
				"      \"Roteiro\",\r\n" + 
				"      \"Santa Luzia do Norte\",\r\n" + 
				"      \"Santana do Ipanema\",\r\n" + 
				"      \"Santana do Mundaú\",\r\n" + 
				"      \"São Brás\",\r\n" + 
				"      \"São José da Laje\",\r\n" + 
				"      \"São José da Tapera\",\r\n" + 
				"      \"São Luís do Quitunde\",\r\n" + 
				"      \"São Miguel dos Campos\",\r\n" + 
				"      \"São Miguel dos Milagres\",\r\n" + 
				"      \"São Sebastião\",\r\n" + 
				"      \"Satuba\",\r\n" + 
				"      \"Senador Rui Palmeira\",\r\n" + 
				"      \"Tanque d'Arca\",\r\n" + 
				"      \"Taquarana\",\r\n" + 
				"      \"Teotônio Vilela\",\r\n" + 
				"      \"Traipu\",\r\n" + 
				"      \"União dos Palmares\",\r\n" + 
				"      \"Viçosa\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"AM\",\r\n" + 
				"    \"nome\": \"Amazonas\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Alvarães\",\r\n" + 
				"      \"Amaturá\",\r\n" + 
				"      \"Anamã\",\r\n" + 
				"      \"Anori\",\r\n" + 
				"      \"Apuí\",\r\n" + 
				"      \"Atalaia do Norte\",\r\n" + 
				"      \"Autazes\",\r\n" + 
				"      \"Barcelos\",\r\n" + 
				"      \"Barreirinha\",\r\n" + 
				"      \"Benjamin Constant\",\r\n" + 
				"      \"Beruri\",\r\n" + 
				"      \"Boa Vista do Ramos\",\r\n" + 
				"      \"Boca do Acre\",\r\n" + 
				"      \"Borba\",\r\n" + 
				"      \"Caapiranga\",\r\n" + 
				"      \"Canutama\",\r\n" + 
				"      \"Carauari\",\r\n" + 
				"      \"Careiro\",\r\n" + 
				"      \"Careiro da Várzea\",\r\n" + 
				"      \"Coari\",\r\n" + 
				"      \"Codajás\",\r\n" + 
				"      \"Eirunepé\",\r\n" + 
				"      \"Envira\",\r\n" + 
				"      \"Fonte Boa\",\r\n" + 
				"      \"Guajará\",\r\n" + 
				"      \"Humaitá\",\r\n" + 
				"      \"Ipixuna\",\r\n" + 
				"      \"Iranduba\",\r\n" + 
				"      \"Itacoatiara\",\r\n" + 
				"      \"Itamarati\",\r\n" + 
				"      \"Itapiranga\",\r\n" + 
				"      \"Japurá\",\r\n" + 
				"      \"Juruá\",\r\n" + 
				"      \"Jutaí\",\r\n" + 
				"      \"Lábrea\",\r\n" + 
				"      \"Manacapuru\",\r\n" + 
				"      \"Manaquiri\",\r\n" + 
				"      \"Manaus\",\r\n" + 
				"      \"Manicoré\",\r\n" + 
				"      \"Maraã\",\r\n" + 
				"      \"Maués\",\r\n" + 
				"      \"Nhamundá\",\r\n" + 
				"      \"Nova Olinda do Norte\",\r\n" + 
				"      \"Novo Airão\",\r\n" + 
				"      \"Novo Aripuanã\",\r\n" + 
				"      \"Parintins\",\r\n" + 
				"      \"Pauini\",\r\n" + 
				"      \"Presidente Figueiredo\",\r\n" + 
				"      \"Rio Preto da Eva\",\r\n" + 
				"      \"Santa Isabel do Rio Negro\",\r\n" + 
				"      \"Santo Antônio do Içá\",\r\n" + 
				"      \"São Gabriel da Cachoeira\",\r\n" + 
				"      \"São Paulo de Olivença\",\r\n" + 
				"      \"São Sebastião do Uatumã\",\r\n" + 
				"      \"Silves\",\r\n" + 
				"      \"Tabatinga\",\r\n" + 
				"      \"Tapauá\",\r\n" + 
				"      \"Tefé\",\r\n" + 
				"      \"Tonantins\",\r\n" + 
				"      \"Uarini\",\r\n" + 
				"      \"Urucará\",\r\n" + 
				"      \"Urucurituba\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"AP\",\r\n" + 
				"    \"nome\": \"Amapá\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Amapá\",\r\n" + 
				"      \"Calçoene\",\r\n" + 
				"      \"Cutias\",\r\n" + 
				"      \"Ferreira Gomes\",\r\n" + 
				"      \"Itaubal\",\r\n" + 
				"      \"Laranjal do Jari\",\r\n" + 
				"      \"Macapá\",\r\n" + 
				"      \"Mazagão\",\r\n" + 
				"      \"Oiapoque\",\r\n" + 
				"      \"Pedra Branca do Amapari\",\r\n" + 
				"      \"Porto Grande\",\r\n" + 
				"      \"Pracuúba\",\r\n" + 
				"      \"Santana\",\r\n" + 
				"      \"Serra do Navio\",\r\n" + 
				"      \"Tartarugalzinho\",\r\n" + 
				"      \"Vitória do Jari\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"BA\",\r\n" + 
				"    \"nome\": \"Bahia\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Abaíra\",\r\n" + 
				"      \"Abaré\",\r\n" + 
				"      \"Acajutiba\",\r\n" + 
				"      \"Adustina\",\r\n" + 
				"      \"Água Fria\",\r\n" + 
				"      \"Aiquara\",\r\n" + 
				"      \"Alagoinhas\",\r\n" + 
				"      \"Alcobaça\",\r\n" + 
				"      \"Almadina\",\r\n" + 
				"      \"Amargosa\",\r\n" + 
				"      \"Amélia Rodrigues\",\r\n" + 
				"      \"América Dourada\",\r\n" + 
				"      \"Anagé\",\r\n" + 
				"      \"Andaraí\",\r\n" + 
				"      \"Andorinha\",\r\n" + 
				"      \"Angical\",\r\n" + 
				"      \"Anguera\",\r\n" + 
				"      \"Antas\",\r\n" + 
				"      \"Antônio Cardoso\",\r\n" + 
				"      \"Antônio Gonçalves\",\r\n" + 
				"      \"Aporá\",\r\n" + 
				"      \"Apuarema\",\r\n" + 
				"      \"Araças\",\r\n" + 
				"      \"Aracatu\",\r\n" + 
				"      \"Araci\",\r\n" + 
				"      \"Aramari\",\r\n" + 
				"      \"Arataca\",\r\n" + 
				"      \"Aratuípe\",\r\n" + 
				"      \"Aurelino Leal\",\r\n" + 
				"      \"Baianópolis\",\r\n" + 
				"      \"Baixa Grande\",\r\n" + 
				"      \"Banzaê\",\r\n" + 
				"      \"Barra\",\r\n" + 
				"      \"Barra da Estiva\",\r\n" + 
				"      \"Barra do Choça\",\r\n" + 
				"      \"Barra do Mendes\",\r\n" + 
				"      \"Barra do Rocha\",\r\n" + 
				"      \"Barreiras\",\r\n" + 
				"      \"Barro Alto\",\r\n" + 
				"      \"Barrocas\",\r\n" + 
				"      \"Barro Preto\",\r\n" + 
				"      \"Belmonte\",\r\n" + 
				"      \"Belo Campo\",\r\n" + 
				"      \"Biritinga\",\r\n" + 
				"      \"Boa Nova\",\r\n" + 
				"      \"Boa Vista do Tupim\",\r\n" + 
				"      \"Bom Jesus da Lapa\",\r\n" + 
				"      \"Bom Jesus da Serra\",\r\n" + 
				"      \"Boninal\",\r\n" + 
				"      \"Bonito\",\r\n" + 
				"      \"Boquira\",\r\n" + 
				"      \"Botuporã\",\r\n" + 
				"      \"Brejões\",\r\n" + 
				"      \"Brejolândia\",\r\n" + 
				"      \"Brotas de Macaúbas\",\r\n" + 
				"      \"Brumado\",\r\n" + 
				"      \"Buerarema\",\r\n" + 
				"      \"Buritirama\",\r\n" + 
				"      \"Caatiba\",\r\n" + 
				"      \"Cabaceiras do Paraguaçu\",\r\n" + 
				"      \"Cachoeira\",\r\n" + 
				"      \"Caculé\",\r\n" + 
				"      \"Caém\",\r\n" + 
				"      \"Caetanos\",\r\n" + 
				"      \"Caetité\",\r\n" + 
				"      \"Cafarnaum\",\r\n" + 
				"      \"Cairu\",\r\n" + 
				"      \"Caldeirão Grande\",\r\n" + 
				"      \"Camacan\",\r\n" + 
				"      \"Camaçari\",\r\n" + 
				"      \"Camamu\",\r\n" + 
				"      \"Campo Alegre de Lourdes\",\r\n" + 
				"      \"Campo Formoso\",\r\n" + 
				"      \"Canápolis\",\r\n" + 
				"      \"Canarana\",\r\n" + 
				"      \"Canavieiras\",\r\n" + 
				"      \"Candeal\",\r\n" + 
				"      \"Candeias\",\r\n" + 
				"      \"Candiba\",\r\n" + 
				"      \"Cândido Sales\",\r\n" + 
				"      \"Cansanção\",\r\n" + 
				"      \"Canudos\",\r\n" + 
				"      \"Capela do Alto Alegre\",\r\n" + 
				"      \"Capim Grosso\",\r\n" + 
				"      \"Caraíbas\",\r\n" + 
				"      \"Caravelas\",\r\n" + 
				"      \"Cardeal da Silva\",\r\n" + 
				"      \"Carinhanha\",\r\n" + 
				"      \"Casa Nova\",\r\n" + 
				"      \"Castro Alves\",\r\n" + 
				"      \"Catolândia\",\r\n" + 
				"      \"Catu\",\r\n" + 
				"      \"Caturama\",\r\n" + 
				"      \"Central\",\r\n" + 
				"      \"Chorrochó\",\r\n" + 
				"      \"Cícero Dantas\",\r\n" + 
				"      \"Cipó\",\r\n" + 
				"      \"Coaraci\",\r\n" + 
				"      \"Cocos\",\r\n" + 
				"      \"Conceição da Feira\",\r\n" + 
				"      \"Conceição do Almeida\",\r\n" + 
				"      \"Conceição do Coité\",\r\n" + 
				"      \"Conceição do Jacuípe\",\r\n" + 
				"      \"Conde\",\r\n" + 
				"      \"Condeúba\",\r\n" + 
				"      \"Contendas do Sincorá\",\r\n" + 
				"      \"Coração de Maria\",\r\n" + 
				"      \"Cordeiros\",\r\n" + 
				"      \"Coribe\",\r\n" + 
				"      \"Coronel João Sá\",\r\n" + 
				"      \"Correntina\",\r\n" + 
				"      \"Cotegipe\",\r\n" + 
				"      \"Cravolândia\",\r\n" + 
				"      \"Crisópolis\",\r\n" + 
				"      \"Cristópolis\",\r\n" + 
				"      \"Cruz das Almas\",\r\n" + 
				"      \"Curaçá\",\r\n" + 
				"      \"Dário Meira\",\r\n" + 
				"      \"Dias d'Ávila\",\r\n" + 
				"      \"Dom Basílio\",\r\n" + 
				"      \"Dom Macedo Costa\",\r\n" + 
				"      \"Elísio Medrado\",\r\n" + 
				"      \"Encruzilhada\",\r\n" + 
				"      \"Entre Rios\",\r\n" + 
				"      \"Érico Cardoso\",\r\n" + 
				"      \"Esplanada\",\r\n" + 
				"      \"Euclides da Cunha\",\r\n" + 
				"      \"Eunápolis\",\r\n" + 
				"      \"Fátima\",\r\n" + 
				"      \"Feira da Mata\",\r\n" + 
				"      \"Feira de Santana\",\r\n" + 
				"      \"Filadélfia\",\r\n" + 
				"      \"Firmino Alves\",\r\n" + 
				"      \"Floresta Azul\",\r\n" + 
				"      \"Formosa do Rio Preto\",\r\n" + 
				"      \"Gandu\",\r\n" + 
				"      \"Gavião\",\r\n" + 
				"      \"Gentio do Ouro\",\r\n" + 
				"      \"Glória\",\r\n" + 
				"      \"Gongogi\",\r\n" + 
				"      \"Governador Mangabeira\",\r\n" + 
				"      \"Guajeru\",\r\n" + 
				"      \"Guanambi\",\r\n" + 
				"      \"Guaratinga\",\r\n" + 
				"      \"Heliópolis\",\r\n" + 
				"      \"Iaçu\",\r\n" + 
				"      \"Ibiassucê\",\r\n" + 
				"      \"Ibicaraí\",\r\n" + 
				"      \"Ibicoara\",\r\n" + 
				"      \"Ibicuí\",\r\n" + 
				"      \"Ibipeba\",\r\n" + 
				"      \"Ibipitanga\",\r\n" + 
				"      \"Ibiquera\",\r\n" + 
				"      \"Ibirapitanga\",\r\n" + 
				"      \"Ibirapuã\",\r\n" + 
				"      \"Ibirataia\",\r\n" + 
				"      \"Ibitiara\",\r\n" + 
				"      \"Ibititá\",\r\n" + 
				"      \"Ibotirama\",\r\n" + 
				"      \"Ichu\",\r\n" + 
				"      \"Igaporã\",\r\n" + 
				"      \"Igrapiúna\",\r\n" + 
				"      \"Iguaí\",\r\n" + 
				"      \"Ilhéus\",\r\n" + 
				"      \"Inhambupe\",\r\n" + 
				"      \"Ipecaetá\",\r\n" + 
				"      \"Ipiaú\",\r\n" + 
				"      \"Ipirá\",\r\n" + 
				"      \"Ipupiara\",\r\n" + 
				"      \"Irajuba\",\r\n" + 
				"      \"Iramaia\",\r\n" + 
				"      \"Iraquara\",\r\n" + 
				"      \"Irará\",\r\n" + 
				"      \"Irecê\",\r\n" + 
				"      \"Itabela\",\r\n" + 
				"      \"Itaberaba\",\r\n" + 
				"      \"Itabuna\",\r\n" + 
				"      \"Itacaré\",\r\n" + 
				"      \"Itaeté\",\r\n" + 
				"      \"Itagi\",\r\n" + 
				"      \"Itagibá\",\r\n" + 
				"      \"Itagimirim\",\r\n" + 
				"      \"Itaguaçu da Bahia\",\r\n" + 
				"      \"Itaju do Colônia\",\r\n" + 
				"      \"Itajuípe\",\r\n" + 
				"      \"Itamaraju\",\r\n" + 
				"      \"Itamari\",\r\n" + 
				"      \"Itambé\",\r\n" + 
				"      \"Itanagra\",\r\n" + 
				"      \"Itanhém\",\r\n" + 
				"      \"Itaparica\",\r\n" + 
				"      \"Itapé\",\r\n" + 
				"      \"Itapebi\",\r\n" + 
				"      \"Itapetinga\",\r\n" + 
				"      \"Itapicuru\",\r\n" + 
				"      \"Itapitanga\",\r\n" + 
				"      \"Itaquara\",\r\n" + 
				"      \"Itarantim\",\r\n" + 
				"      \"Itatim\",\r\n" + 
				"      \"Itiruçu\",\r\n" + 
				"      \"Itiúba\",\r\n" + 
				"      \"Itororó\",\r\n" + 
				"      \"Ituaçu\",\r\n" + 
				"      \"Ituberá\",\r\n" + 
				"      \"Iuiú\",\r\n" + 
				"      \"Jaborandi\",\r\n" + 
				"      \"Jacaraci\",\r\n" + 
				"      \"Jacobina\",\r\n" + 
				"      \"Jaguaquara\",\r\n" + 
				"      \"Jaguarari\",\r\n" + 
				"      \"Jaguaripe\",\r\n" + 
				"      \"Jandaíra\",\r\n" + 
				"      \"Jequié\",\r\n" + 
				"      \"Jeremoabo\",\r\n" + 
				"      \"Jiquiriçá\",\r\n" + 
				"      \"Jitaúna\",\r\n" + 
				"      \"João Dourado\",\r\n" + 
				"      \"Juazeiro\",\r\n" + 
				"      \"Jucuruçu\",\r\n" + 
				"      \"Jussara\",\r\n" + 
				"      \"Jussari\",\r\n" + 
				"      \"Jussiape\",\r\n" + 
				"      \"Lafaiete Coutinho\",\r\n" + 
				"      \"Lagoa Real\",\r\n" + 
				"      \"Laje\",\r\n" + 
				"      \"Lajedão\",\r\n" + 
				"      \"Lajedinho\",\r\n" + 
				"      \"Lajedo do Tabocal\",\r\n" + 
				"      \"Lamarão\",\r\n" + 
				"      \"Lapão\",\r\n" + 
				"      \"Lauro de Freitas\",\r\n" + 
				"      \"Lençóis\",\r\n" + 
				"      \"Licínio de Almeida\",\r\n" + 
				"      \"Livramento de Nossa Senhora\",\r\n" + 
				"      \"Luís Eduardo Magalhães\",\r\n" + 
				"      \"Macajuba\",\r\n" + 
				"      \"Macarani\",\r\n" + 
				"      \"Macaúbas\",\r\n" + 
				"      \"Macururé\",\r\n" + 
				"      \"Madre de Deus\",\r\n" + 
				"      \"Maetinga\",\r\n" + 
				"      \"Maiquinique\",\r\n" + 
				"      \"Mairi\",\r\n" + 
				"      \"Malhada\",\r\n" + 
				"      \"Malhada de Pedras\",\r\n" + 
				"      \"Manoel Vitorino\",\r\n" + 
				"      \"Mansidão\",\r\n" + 
				"      \"Maracás\",\r\n" + 
				"      \"Maragogipe\",\r\n" + 
				"      \"Maraú\",\r\n" + 
				"      \"Marcionílio Souza\",\r\n" + 
				"      \"Mascote\",\r\n" + 
				"      \"Mata de São João\",\r\n" + 
				"      \"Matina\",\r\n" + 
				"      \"Medeiros Neto\",\r\n" + 
				"      \"Miguel Calmon\",\r\n" + 
				"      \"Milagres\",\r\n" + 
				"      \"Mirangaba\",\r\n" + 
				"      \"Mirante\",\r\n" + 
				"      \"Monte Santo\",\r\n" + 
				"      \"Morpará\",\r\n" + 
				"      \"Morro do Chapéu\",\r\n" + 
				"      \"Mortugaba\",\r\n" + 
				"      \"Mucugê\",\r\n" + 
				"      \"Mucuri\",\r\n" + 
				"      \"Mulungu do Morro\",\r\n" + 
				"      \"Mundo Novo\",\r\n" + 
				"      \"Muniz Ferreira\",\r\n" + 
				"      \"Muquém de São Francisco\",\r\n" + 
				"      \"Muritiba\",\r\n" + 
				"      \"Mutuípe\",\r\n" + 
				"      \"Nazaré\",\r\n" + 
				"      \"Nilo Peçanha\",\r\n" + 
				"      \"Nordestina\",\r\n" + 
				"      \"Nova Canaã\",\r\n" + 
				"      \"Nova Fátima\",\r\n" + 
				"      \"Nova Ibiá\",\r\n" + 
				"      \"Nova Itarana\",\r\n" + 
				"      \"Nova Redenção\",\r\n" + 
				"      \"Nova Soure\",\r\n" + 
				"      \"Nova Viçosa\",\r\n" + 
				"      \"Novo Horizonte\",\r\n" + 
				"      \"Novo Triunfo\",\r\n" + 
				"      \"Olindina\",\r\n" + 
				"      \"Oliveira dos Brejinhos\",\r\n" + 
				"      \"Ouriçangas\",\r\n" + 
				"      \"Ourolândia\",\r\n" + 
				"      \"Palmas de Monte Alto\",\r\n" + 
				"      \"Palmeiras\",\r\n" + 
				"      \"Paramirim\",\r\n" + 
				"      \"Paratinga\",\r\n" + 
				"      \"Paripiranga\",\r\n" + 
				"      \"Pau Brasil\",\r\n" + 
				"      \"Paulo Afonso\",\r\n" + 
				"      \"Pé de Serra\",\r\n" + 
				"      \"Pedrão\",\r\n" + 
				"      \"Pedro Alexandre\",\r\n" + 
				"      \"Piatã\",\r\n" + 
				"      \"Pilão Arcado\",\r\n" + 
				"      \"Pindaí\",\r\n" + 
				"      \"Pindobaçu\",\r\n" + 
				"      \"Pintadas\",\r\n" + 
				"      \"Piraí do Norte\",\r\n" + 
				"      \"Piripá\",\r\n" + 
				"      \"Piritiba\",\r\n" + 
				"      \"Planaltino\",\r\n" + 
				"      \"Planalto\",\r\n" + 
				"      \"Poções\",\r\n" + 
				"      \"Pojuca\",\r\n" + 
				"      \"Ponto Novo\",\r\n" + 
				"      \"Porto Seguro\",\r\n" + 
				"      \"Potiraguá\",\r\n" + 
				"      \"Prado\",\r\n" + 
				"      \"Presidente Dutra\",\r\n" + 
				"      \"Presidente Jânio Quadros\",\r\n" + 
				"      \"Presidente Tancredo Neves\",\r\n" + 
				"      \"Queimadas\",\r\n" + 
				"      \"Quijingue\",\r\n" + 
				"      \"Quixabeira\",\r\n" + 
				"      \"Rafael Jambeiro\",\r\n" + 
				"      \"Remanso\",\r\n" + 
				"      \"Retirolândia\",\r\n" + 
				"      \"Riachão das Neves\",\r\n" + 
				"      \"Riachão do Jacuípe\",\r\n" + 
				"      \"Riacho de Santana\",\r\n" + 
				"      \"Ribeira do Amparo\",\r\n" + 
				"      \"Ribeira do Pombal\",\r\n" + 
				"      \"Ribeirão do Largo\",\r\n" + 
				"      \"Rio de Contas\",\r\n" + 
				"      \"Rio do Antônio\",\r\n" + 
				"      \"Rio do Pires\",\r\n" + 
				"      \"Rio Real\",\r\n" + 
				"      \"Rodelas\",\r\n" + 
				"      \"Ruy Barbosa\",\r\n" + 
				"      \"Salinas da Margarida\",\r\n" + 
				"      \"Salvador\",\r\n" + 
				"      \"Santa Bárbara\",\r\n" + 
				"      \"Santa Brígida\",\r\n" + 
				"      \"Santa Cruz Cabrália\",\r\n" + 
				"      \"Santa Cruz da Vitória\",\r\n" + 
				"      \"Santa Inês\",\r\n" + 
				"      \"Santa Luzia\",\r\n" + 
				"      \"Santa Maria da Vitória\",\r\n" + 
				"      \"Santa Rita de Cássia\",\r\n" + 
				"      \"Santa Teresinha\",\r\n" + 
				"      \"Santaluz\",\r\n" + 
				"      \"Santana\",\r\n" + 
				"      \"Santanópolis\",\r\n" + 
				"      \"Santo Amaro\",\r\n" + 
				"      \"Santo Antônio de Jesus\",\r\n" + 
				"      \"Santo Estêvão\",\r\n" + 
				"      \"São Desidério\",\r\n" + 
				"      \"São Domingos\",\r\n" + 
				"      \"São Felipe\",\r\n" + 
				"      \"São Félix\",\r\n" + 
				"      \"São Félix do Coribe\",\r\n" + 
				"      \"São Francisco do Conde\",\r\n" + 
				"      \"São Gabriel\",\r\n" + 
				"      \"São Gonçalo dos Campos\",\r\n" + 
				"      \"São José da Vitória\",\r\n" + 
				"      \"São José do Jacuípe\",\r\n" + 
				"      \"São Miguel das Matas\",\r\n" + 
				"      \"São Sebastião do Passé\",\r\n" + 
				"      \"Sapeaçu\",\r\n" + 
				"      \"Sátiro Dias\",\r\n" + 
				"      \"Saubara\",\r\n" + 
				"      \"Saúde\",\r\n" + 
				"      \"Seabra\",\r\n" + 
				"      \"Sebastião Laranjeiras\",\r\n" + 
				"      \"Senhor do Bonfim\",\r\n" + 
				"      \"Sento Sé\",\r\n" + 
				"      \"Serra do Ramalho\",\r\n" + 
				"      \"Serra Dourada\",\r\n" + 
				"      \"Serra Preta\",\r\n" + 
				"      \"Serrinha\",\r\n" + 
				"      \"Serrolândia\",\r\n" + 
				"      \"Simões Filho\",\r\n" + 
				"      \"Sítio do Mato\",\r\n" + 
				"      \"Sítio do Quinto\",\r\n" + 
				"      \"Sobradinho\",\r\n" + 
				"      \"Souto Soares\",\r\n" + 
				"      \"Tabocas do Brejo Velho\",\r\n" + 
				"      \"Tanhaçu\",\r\n" + 
				"      \"Tanque Novo\",\r\n" + 
				"      \"Tanquinho\",\r\n" + 
				"      \"Taperoá\",\r\n" + 
				"      \"Tapiramutá\",\r\n" + 
				"      \"Teixeira de Freitas\",\r\n" + 
				"      \"Teodoro Sampaio\",\r\n" + 
				"      \"Teofilândia\",\r\n" + 
				"      \"Teolândia\",\r\n" + 
				"      \"Terra Nova\",\r\n" + 
				"      \"Tremedal\",\r\n" + 
				"      \"Tucano\",\r\n" + 
				"      \"Uauá\",\r\n" + 
				"      \"Ubaíra\",\r\n" + 
				"      \"Ubaitaba\",\r\n" + 
				"      \"Ubatã\",\r\n" + 
				"      \"Uibaí\",\r\n" + 
				"      \"Umburanas\",\r\n" + 
				"      \"Una\",\r\n" + 
				"      \"Urandi\",\r\n" + 
				"      \"Uruçuca\",\r\n" + 
				"      \"Utinga\",\r\n" + 
				"      \"Valença\",\r\n" + 
				"      \"Valente\",\r\n" + 
				"      \"Várzea da Roça\",\r\n" + 
				"      \"Várzea do Poço\",\r\n" + 
				"      \"Várzea Nova\",\r\n" + 
				"      \"Varzedo\",\r\n" + 
				"      \"Vera Cruz\",\r\n" + 
				"      \"Vereda\",\r\n" + 
				"      \"Vitória da Conquista\",\r\n" + 
				"      \"Wagner\",\r\n" + 
				"      \"Wanderley\",\r\n" + 
				"      \"Wenceslau Guimarães\",\r\n" + 
				"      \"Xique-Xique\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"CE\",\r\n" + 
				"    \"nome\": \"Ceará\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Abaiara\",\r\n" + 
				"      \"Acarapé\",\r\n" + 
				"      \"Acaraú\",\r\n" + 
				"      \"Acopiara\",\r\n" + 
				"      \"Aiuaba\",\r\n" + 
				"      \"Alcântaras\",\r\n" + 
				"      \"Altaneira\",\r\n" + 
				"      \"Alto Santo\",\r\n" + 
				"      \"Amontada\",\r\n" + 
				"      \"Antonina do Norte\",\r\n" + 
				"      \"Apuiarés\",\r\n" + 
				"      \"Aquiraz\",\r\n" + 
				"      \"Aracati\",\r\n" + 
				"      \"Aracoiaba\",\r\n" + 
				"      \"Ararendá\",\r\n" + 
				"      \"Araripe\",\r\n" + 
				"      \"Aratuba\",\r\n" + 
				"      \"Arneiroz\",\r\n" + 
				"      \"Assaré\",\r\n" + 
				"      \"Aurora\",\r\n" + 
				"      \"Baixio\",\r\n" + 
				"      \"Banabuiú\",\r\n" + 
				"      \"Barbalha\",\r\n" + 
				"      \"Barreira\",\r\n" + 
				"      \"Barro\",\r\n" + 
				"      \"Barroquinha\",\r\n" + 
				"      \"Baturité\",\r\n" + 
				"      \"Beberibe\",\r\n" + 
				"      \"Bela Cruz\",\r\n" + 
				"      \"Boa Viagem\",\r\n" + 
				"      \"Brejo Santo\",\r\n" + 
				"      \"Camocim\",\r\n" + 
				"      \"Campos Sales\",\r\n" + 
				"      \"Canindé\",\r\n" + 
				"      \"Capistrano\",\r\n" + 
				"      \"Caridade\",\r\n" + 
				"      \"Cariré\",\r\n" + 
				"      \"Caririaçu\",\r\n" + 
				"      \"Cariús\",\r\n" + 
				"      \"Carnaubal\",\r\n" + 
				"      \"Cascavel\",\r\n" + 
				"      \"Catarina\",\r\n" + 
				"      \"Catunda\",\r\n" + 
				"      \"Caucaia\",\r\n" + 
				"      \"Cedro\",\r\n" + 
				"      \"Chaval\",\r\n" + 
				"      \"Choró\",\r\n" + 
				"      \"Chorozinho\",\r\n" + 
				"      \"Coreaú\",\r\n" + 
				"      \"Crateús\",\r\n" + 
				"      \"Crato\",\r\n" + 
				"      \"Croatá\",\r\n" + 
				"      \"Cruz\",\r\n" + 
				"      \"Deputado Irapuan Pinheiro\",\r\n" + 
				"      \"Ererê\",\r\n" + 
				"      \"Eusébio\",\r\n" + 
				"      \"Farias Brito\",\r\n" + 
				"      \"Forquilha\",\r\n" + 
				"      \"Fortaleza\",\r\n" + 
				"      \"Fortim\",\r\n" + 
				"      \"Frecheirinha\",\r\n" + 
				"      \"General Sampaio\",\r\n" + 
				"      \"Graça\",\r\n" + 
				"      \"Granja\",\r\n" + 
				"      \"Granjeiro\",\r\n" + 
				"      \"Groaíras\",\r\n" + 
				"      \"Guaiúba\",\r\n" + 
				"      \"Guaraciaba do Norte\",\r\n" + 
				"      \"Guaramiranga\",\r\n" + 
				"      \"Hidrolândia\",\r\n" + 
				"      \"Horizonte\",\r\n" + 
				"      \"Ibaretama\",\r\n" + 
				"      \"Ibiapina\",\r\n" + 
				"      \"Ibicuitinga\",\r\n" + 
				"      \"Icapuí\",\r\n" + 
				"      \"Icó\",\r\n" + 
				"      \"Iguatu\",\r\n" + 
				"      \"Independência\",\r\n" + 
				"      \"Ipaporanga\",\r\n" + 
				"      \"Ipaumirim\",\r\n" + 
				"      \"Ipu\",\r\n" + 
				"      \"Ipueiras\",\r\n" + 
				"      \"Iracema\",\r\n" + 
				"      \"Irauçuba\",\r\n" + 
				"      \"Itaiçaba\",\r\n" + 
				"      \"Itaitinga\",\r\n" + 
				"      \"Itapagé\",\r\n" + 
				"      \"Itapipoca\",\r\n" + 
				"      \"Itapiúna\",\r\n" + 
				"      \"Itarema\",\r\n" + 
				"      \"Itatira\",\r\n" + 
				"      \"Jaguaretama\",\r\n" + 
				"      \"Jaguaribara\",\r\n" + 
				"      \"Jaguaribe\",\r\n" + 
				"      \"Jaguaruana\",\r\n" + 
				"      \"Jardim\",\r\n" + 
				"      \"Jati\",\r\n" + 
				"      \"Jijoca de Jericoaroara\",\r\n" + 
				"      \"Juazeiro do Norte\",\r\n" + 
				"      \"Jucás\",\r\n" + 
				"      \"Lavras da Mangabeira\",\r\n" + 
				"      \"Limoeiro do Norte\",\r\n" + 
				"      \"Madalena\",\r\n" + 
				"      \"Maracanaú\",\r\n" + 
				"      \"Maranguape\",\r\n" + 
				"      \"Marco\",\r\n" + 
				"      \"Martinópole\",\r\n" + 
				"      \"Massapê\",\r\n" + 
				"      \"Mauriti\",\r\n" + 
				"      \"Meruoca\",\r\n" + 
				"      \"Milagres\",\r\n" + 
				"      \"Milhã\",\r\n" + 
				"      \"Miraíma\",\r\n" + 
				"      \"Missão Velha\",\r\n" + 
				"      \"Mombaça\",\r\n" + 
				"      \"Monsenhor Tabosa\",\r\n" + 
				"      \"Morada Nova\",\r\n" + 
				"      \"Moraújo\",\r\n" + 
				"      \"Morrinhos\",\r\n" + 
				"      \"Mucambo\",\r\n" + 
				"      \"Mulungu\",\r\n" + 
				"      \"Nova Olinda\",\r\n" + 
				"      \"Nova Russas\",\r\n" + 
				"      \"Novo Oriente\",\r\n" + 
				"      \"Ocara\",\r\n" + 
				"      \"Orós\",\r\n" + 
				"      \"Pacajus\",\r\n" + 
				"      \"Pacatuba\",\r\n" + 
				"      \"Pacoti\",\r\n" + 
				"      \"Pacujá\",\r\n" + 
				"      \"Palhano\",\r\n" + 
				"      \"Palmácia\",\r\n" + 
				"      \"Paracuru\",\r\n" + 
				"      \"Paraipaba\",\r\n" + 
				"      \"Parambu\",\r\n" + 
				"      \"Paramoti\",\r\n" + 
				"      \"Pedra Branca\",\r\n" + 
				"      \"Penaforte\",\r\n" + 
				"      \"Pentecoste\",\r\n" + 
				"      \"Pereiro\",\r\n" + 
				"      \"Pindoretama\",\r\n" + 
				"      \"Piquet Carneiro\",\r\n" + 
				"      \"Pires Ferreira\",\r\n" + 
				"      \"Poranga\",\r\n" + 
				"      \"Porteiras\",\r\n" + 
				"      \"Potengi\",\r\n" + 
				"      \"Potiretama\",\r\n" + 
				"      \"Quiterianópolis\",\r\n" + 
				"      \"Quixadá\",\r\n" + 
				"      \"Quixelô\",\r\n" + 
				"      \"Quixeramobim\",\r\n" + 
				"      \"Quixeré\",\r\n" + 
				"      \"Redenção\",\r\n" + 
				"      \"Reriutaba\",\r\n" + 
				"      \"Russas\",\r\n" + 
				"      \"Saboeiro\",\r\n" + 
				"      \"Salitre\",\r\n" + 
				"      \"Santa Quitéria\",\r\n" + 
				"      \"Santana do Acaraú\",\r\n" + 
				"      \"Santana do Cariri\",\r\n" + 
				"      \"São Benedito\",\r\n" + 
				"      \"São Gonçalo do Amarante\",\r\n" + 
				"      \"São João do Jaguaribe\",\r\n" + 
				"      \"São Luís do Curu\",\r\n" + 
				"      \"Senador Pompeu\",\r\n" + 
				"      \"Senador Sá\",\r\n" + 
				"      \"Sobral\",\r\n" + 
				"      \"Solonópole\",\r\n" + 
				"      \"Tabuleiro do Norte\",\r\n" + 
				"      \"Tamboril\",\r\n" + 
				"      \"Tarrafas\",\r\n" + 
				"      \"Tauá\",\r\n" + 
				"      \"Tejuçuoca\",\r\n" + 
				"      \"Tianguá\",\r\n" + 
				"      \"Trairi\",\r\n" + 
				"      \"Tururu\",\r\n" + 
				"      \"Ubajara\",\r\n" + 
				"      \"Umari\",\r\n" + 
				"      \"Umirim\",\r\n" + 
				"      \"Uruburetama\",\r\n" + 
				"      \"Uruoca\",\r\n" + 
				"      \"Varjota\",\r\n" + 
				"      \"Várzea Alegre\",\r\n" + 
				"      \"Viçosa do Ceará\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"DF\",\r\n" + 
				"    \"nome\": \"Distrito Federal\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Brasília\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"ES\",\r\n" + 
				"    \"nome\": \"Espírito Santo\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Afonso Cláudio\",\r\n" + 
				"      \"Água Doce do Norte\",\r\n" + 
				"      \"Águia Branca\",\r\n" + 
				"      \"Alegre\",\r\n" + 
				"      \"Alfredo Chaves\",\r\n" + 
				"      \"Alto Rio Novo\",\r\n" + 
				"      \"Anchieta\",\r\n" + 
				"      \"Apiacá\",\r\n" + 
				"      \"Aracruz\",\r\n" + 
				"      \"Atilio Vivacqua\",\r\n" + 
				"      \"Baixo Guandu\",\r\n" + 
				"      \"Barra de São Francisco\",\r\n" + 
				"      \"Boa Esperança\",\r\n" + 
				"      \"Bom Jesus do Norte\",\r\n" + 
				"      \"Brejetuba\",\r\n" + 
				"      \"Cachoeiro de Itapemirim\",\r\n" + 
				"      \"Cariacica\",\r\n" + 
				"      \"Castelo\",\r\n" + 
				"      \"Colatina\",\r\n" + 
				"      \"Conceição da Barra\",\r\n" + 
				"      \"Conceição do Castelo\",\r\n" + 
				"      \"Divino de São Lourenço\",\r\n" + 
				"      \"Domingos Martins\",\r\n" + 
				"      \"Dores do Rio Preto\",\r\n" + 
				"      \"Ecoporanga\",\r\n" + 
				"      \"Fundão\",\r\n" + 
				"      \"Governador Lindenberg\",\r\n" + 
				"      \"Guaçuí\",\r\n" + 
				"      \"Guarapari\",\r\n" + 
				"      \"Ibatiba\",\r\n" + 
				"      \"Ibiraçu\",\r\n" + 
				"      \"Ibitirama\",\r\n" + 
				"      \"Iconha\",\r\n" + 
				"      \"Irupi\",\r\n" + 
				"      \"Itaguaçu\",\r\n" + 
				"      \"Itapemirim\",\r\n" + 
				"      \"Itarana\",\r\n" + 
				"      \"Iúna\",\r\n" + 
				"      \"Jaguaré\",\r\n" + 
				"      \"Jerônimo Monteiro\",\r\n" + 
				"      \"João Neiva\",\r\n" + 
				"      \"Laranja da Terra\",\r\n" + 
				"      \"Linhares\",\r\n" + 
				"      \"Mantenópolis\",\r\n" + 
				"      \"Marataizes\",\r\n" + 
				"      \"Marechal Floriano\",\r\n" + 
				"      \"Marilândia\",\r\n" + 
				"      \"Mimoso do Sul\",\r\n" + 
				"      \"Montanha\",\r\n" + 
				"      \"Mucurici\",\r\n" + 
				"      \"Muniz Freire\",\r\n" + 
				"      \"Muqui\",\r\n" + 
				"      \"Nova Venécia\",\r\n" + 
				"      \"Pancas\",\r\n" + 
				"      \"Pedro Canário\",\r\n" + 
				"      \"Pinheiros\",\r\n" + 
				"      \"Piúma\",\r\n" + 
				"      \"Ponto Belo\",\r\n" + 
				"      \"Presidente Kennedy\",\r\n" + 
				"      \"Rio Bananal\",\r\n" + 
				"      \"Rio Novo do Sul\",\r\n" + 
				"      \"Santa Leopoldina\",\r\n" + 
				"      \"Santa Maria de Jetibá\",\r\n" + 
				"      \"Santa Teresa\",\r\n" + 
				"      \"São Domingos do Norte\",\r\n" + 
				"      \"São Gabriel da Palha\",\r\n" + 
				"      \"São José do Calçado\",\r\n" + 
				"      \"São Mateus\",\r\n" + 
				"      \"São Roque do Canaã\",\r\n" + 
				"      \"Serra\",\r\n" + 
				"      \"Sooretama\",\r\n" + 
				"      \"Vargem Alta\",\r\n" + 
				"      \"Venda Nova do Imigrante\",\r\n" + 
				"      \"Viana\",\r\n" + 
				"      \"Vila Pavão\",\r\n" + 
				"      \"Vila Valério\",\r\n" + 
				"      \"Vila Velha\",\r\n" + 
				"      \"Vitória\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"GO\",\r\n" + 
				"    \"nome\": \"Goiás\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Abadia de Goiás\",\r\n" + 
				"      \"Abadiânia\",\r\n" + 
				"      \"Acreúna\",\r\n" + 
				"      \"Adelândia\",\r\n" + 
				"      \"Água Fria de Goiás\",\r\n" + 
				"      \"Água Limpa\",\r\n" + 
				"      \"Águas Lindas de Goiás\",\r\n" + 
				"      \"Alexânia\",\r\n" + 
				"      \"Aloândia\",\r\n" + 
				"      \"Alto Horizonte\",\r\n" + 
				"      \"Alto Paraíso de Goiás\",\r\n" + 
				"      \"Alvorada do Norte\",\r\n" + 
				"      \"Amaralina\",\r\n" + 
				"      \"Americano do Brasil\",\r\n" + 
				"      \"Amorinópolis\",\r\n" + 
				"      \"Anápolis\",\r\n" + 
				"      \"Anhanguera\",\r\n" + 
				"      \"Anicuns\",\r\n" + 
				"      \"Aparecida de Goiânia\",\r\n" + 
				"      \"Aparecida do Rio Doce\",\r\n" + 
				"      \"Aporé\",\r\n" + 
				"      \"Araçu\",\r\n" + 
				"      \"Aragarças\",\r\n" + 
				"      \"Aragoiânia\",\r\n" + 
				"      \"Araguapaz\",\r\n" + 
				"      \"Arenópolis\",\r\n" + 
				"      \"Aruanã\",\r\n" + 
				"      \"Aurilândia\",\r\n" + 
				"      \"Avelinópolis\",\r\n" + 
				"      \"Baliza\",\r\n" + 
				"      \"Barro Alto\",\r\n" + 
				"      \"Bela Vista de Goiás\",\r\n" + 
				"      \"Bom Jardim de Goiás\",\r\n" + 
				"      \"Bom Jesus de Goiás\",\r\n" + 
				"      \"Bonfinópolis\",\r\n" + 
				"      \"Bonópolis\",\r\n" + 
				"      \"Brazabrantes\",\r\n" + 
				"      \"Britânia\",\r\n" + 
				"      \"Buriti Alegre\",\r\n" + 
				"      \"Buriti de Goiás\",\r\n" + 
				"      \"Buritinópolis\",\r\n" + 
				"      \"Cabeceiras\",\r\n" + 
				"      \"Cachoeira Alta\",\r\n" + 
				"      \"Cachoeira de Goiás\",\r\n" + 
				"      \"Cachoeira Dourada\",\r\n" + 
				"      \"Caçu\",\r\n" + 
				"      \"Caiapônia\",\r\n" + 
				"      \"Caldas Novas\",\r\n" + 
				"      \"Caldazinha\",\r\n" + 
				"      \"Campestre de Goiás\",\r\n" + 
				"      \"Campinaçu\",\r\n" + 
				"      \"Campinorte\",\r\n" + 
				"      \"Campo Alegre de Goiás\",\r\n" + 
				"      \"Campos Limpo de Goiás\",\r\n" + 
				"      \"Campos Belos\",\r\n" + 
				"      \"Campos Verdes\",\r\n" + 
				"      \"Carmo do Rio Verde\",\r\n" + 
				"      \"Castelândia\",\r\n" + 
				"      \"Catalão\",\r\n" + 
				"      \"Caturaí\",\r\n" + 
				"      \"Cavalcante\",\r\n" + 
				"      \"Ceres\",\r\n" + 
				"      \"Cezarina\",\r\n" + 
				"      \"Chapadão do Céu\",\r\n" + 
				"      \"Cidade Ocidental\",\r\n" + 
				"      \"Cocalzinho de Goiás\",\r\n" + 
				"      \"Colinas do Sul\",\r\n" + 
				"      \"Córrego do Ouro\",\r\n" + 
				"      \"Corumbá de Goiás\",\r\n" + 
				"      \"Corumbaíba\",\r\n" + 
				"      \"Cristalina\",\r\n" + 
				"      \"Cristianópolis\",\r\n" + 
				"      \"Crixás\",\r\n" + 
				"      \"Cromínia\",\r\n" + 
				"      \"Cumari\",\r\n" + 
				"      \"Damianópolis\",\r\n" + 
				"      \"Damolândia\",\r\n" + 
				"      \"Davinópolis\",\r\n" + 
				"      \"Diorama\",\r\n" + 
				"      \"Divinópolis de Goiás\",\r\n" + 
				"      \"Doverlândia\",\r\n" + 
				"      \"Edealina\",\r\n" + 
				"      \"Edéia\",\r\n" + 
				"      \"Estrela do Norte\",\r\n" + 
				"      \"Faina\",\r\n" + 
				"      \"Fazenda Nova\",\r\n" + 
				"      \"Firminópolis\",\r\n" + 
				"      \"Flores de Goiás\",\r\n" + 
				"      \"Formosa\",\r\n" + 
				"      \"Formoso\",\r\n" + 
				"      \"Gameleira de Goiás\",\r\n" + 
				"      \"Goianápolis\",\r\n" + 
				"      \"Goiandira\",\r\n" + 
				"      \"Goianésia\",\r\n" + 
				"      \"Goiânia\",\r\n" + 
				"      \"Goianira\",\r\n" + 
				"      \"Goiás\",\r\n" + 
				"      \"Goiatuba\",\r\n" + 
				"      \"Gouvelândia\",\r\n" + 
				"      \"Guapó\",\r\n" + 
				"      \"Guaraíta\",\r\n" + 
				"      \"Guarani de Goiás\",\r\n" + 
				"      \"Guarinos\",\r\n" + 
				"      \"Heitoraí\",\r\n" + 
				"      \"Hidrolândia\",\r\n" + 
				"      \"Hidrolina\",\r\n" + 
				"      \"Iaciara\",\r\n" + 
				"      \"Inaciolândia\",\r\n" + 
				"      \"Indiara\",\r\n" + 
				"      \"Inhumas\",\r\n" + 
				"      \"Ipameri\",\r\n" + 
				"      \"Ipiranga de Goiás\",\r\n" + 
				"      \"Iporá\",\r\n" + 
				"      \"Israelândia\",\r\n" + 
				"      \"Itaberaí\",\r\n" + 
				"      \"Itaguari\",\r\n" + 
				"      \"Itaguaru\",\r\n" + 
				"      \"Itajá\",\r\n" + 
				"      \"Itapaci\",\r\n" + 
				"      \"Itapirapuã\",\r\n" + 
				"      \"Itapuranga\",\r\n" + 
				"      \"Itarumã\",\r\n" + 
				"      \"Itauçu\",\r\n" + 
				"      \"Itumbiara\",\r\n" + 
				"      \"Ivolândia\",\r\n" + 
				"      \"Jandaia\",\r\n" + 
				"      \"Jaraguá\",\r\n" + 
				"      \"Jataí\",\r\n" + 
				"      \"Jaupaci\",\r\n" + 
				"      \"Jesúpolis\",\r\n" + 
				"      \"Joviânia\",\r\n" + 
				"      \"Jussara\",\r\n" + 
				"      \"Lagoa Santa\",\r\n" + 
				"      \"Leopoldo de Bulhões\",\r\n" + 
				"      \"Luziânia\",\r\n" + 
				"      \"Mairipotaba\",\r\n" + 
				"      \"Mambaí\",\r\n" + 
				"      \"Mara Rosa\",\r\n" + 
				"      \"Marzagão\",\r\n" + 
				"      \"Matrinchã\",\r\n" + 
				"      \"Maurilândia\",\r\n" + 
				"      \"Mimoso de Goiás\",\r\n" + 
				"      \"Minaçu\",\r\n" + 
				"      \"Mineiros\",\r\n" + 
				"      \"Moiporá\",\r\n" + 
				"      \"Monte Alegre de Goiás\",\r\n" + 
				"      \"Montes Claros de Goiás\",\r\n" + 
				"      \"Montividiu\",\r\n" + 
				"      \"Montividiu do Norte\",\r\n" + 
				"      \"Morrinhos\",\r\n" + 
				"      \"Morro Agudo de Goiás\",\r\n" + 
				"      \"Mossâmedes\",\r\n" + 
				"      \"Mozarlândia\",\r\n" + 
				"      \"Mundo Novo\",\r\n" + 
				"      \"Mutunópolis\",\r\n" + 
				"      \"Nazário\",\r\n" + 
				"      \"Nerópolis\",\r\n" + 
				"      \"Niquelândia\",\r\n" + 
				"      \"Nova América\",\r\n" + 
				"      \"Nova Aurora\",\r\n" + 
				"      \"Nova Crixás\",\r\n" + 
				"      \"Nova Glória\",\r\n" + 
				"      \"Nova Iguaçu de Goiás\",\r\n" + 
				"      \"Nova Roma\",\r\n" + 
				"      \"Nova Veneza\",\r\n" + 
				"      \"Novo Brasil\",\r\n" + 
				"      \"Novo Gama\",\r\n" + 
				"      \"Novo Planalto\",\r\n" + 
				"      \"Orizona\",\r\n" + 
				"      \"Ouro Verde de Goiás\",\r\n" + 
				"      \"Ouvidor\",\r\n" + 
				"      \"Padre Bernardo\",\r\n" + 
				"      \"Palestina de Goiás\",\r\n" + 
				"      \"Palmeiras de Goiás\",\r\n" + 
				"      \"Palmelo\",\r\n" + 
				"      \"Palminópolis\",\r\n" + 
				"      \"Panamá\",\r\n" + 
				"      \"Paranaiguara\",\r\n" + 
				"      \"Paraúna\",\r\n" + 
				"      \"Perolândia\",\r\n" + 
				"      \"Petrolina de Goiás\",\r\n" + 
				"      \"Pilar de Goiás\",\r\n" + 
				"      \"Piracanjuba\",\r\n" + 
				"      \"Piranhas\",\r\n" + 
				"      \"Pirenópolis\",\r\n" + 
				"      \"Pires do Rio\",\r\n" + 
				"      \"Planaltina\",\r\n" + 
				"      \"Pontalina\",\r\n" + 
				"      \"Porangatu\",\r\n" + 
				"      \"Porteirão\",\r\n" + 
				"      \"Portelândia\",\r\n" + 
				"      \"Posse\",\r\n" + 
				"      \"Professor Jamil\",\r\n" + 
				"      \"Quirinópolis\",\r\n" + 
				"      \"Rialma\",\r\n" + 
				"      \"Rianápolis\",\r\n" + 
				"      \"Rio Quente\",\r\n" + 
				"      \"Rio Verde\",\r\n" + 
				"      \"Rubiataba\",\r\n" + 
				"      \"Sanclerlândia\",\r\n" + 
				"      \"Santa Bárbara de Goiás\",\r\n" + 
				"      \"Santa Cruz de Goiás\",\r\n" + 
				"      \"Santa Fé de Goiás\",\r\n" + 
				"      \"Santa Helena de Goiás\",\r\n" + 
				"      \"Santa Isabel\",\r\n" + 
				"      \"Santa Rita do Araguaia\",\r\n" + 
				"      \"Santa Rita do Novo Destino\",\r\n" + 
				"      \"Santa Rosa de Goiás\",\r\n" + 
				"      \"Santa Tereza de Goiás\",\r\n" + 
				"      \"Santa Terezinha de Goiás\",\r\n" + 
				"      \"Santo Antônio da Barra\",\r\n" + 
				"      \"Santo Antônio de Goiás\",\r\n" + 
				"      \"Santo Antônio do Descoberto\",\r\n" + 
				"      \"São Domingos\",\r\n" + 
				"      \"São Francisco de Goiás\",\r\n" + 
				"      \"São João d'Aliança\",\r\n" + 
				"      \"São João da Paraúna\",\r\n" + 
				"      \"São Luís de Montes Belos\",\r\n" + 
				"      \"São Luíz do Norte\",\r\n" + 
				"      \"São Miguel do Araguaia\",\r\n" + 
				"      \"São Miguel do Passa Quatro\",\r\n" + 
				"      \"São Patrício\",\r\n" + 
				"      \"São Simão\",\r\n" + 
				"      \"Senador Canedo\",\r\n" + 
				"      \"Serranópolis\",\r\n" + 
				"      \"Silvânia\",\r\n" + 
				"      \"Simolândia\",\r\n" + 
				"      \"Sítio d'Abadia\",\r\n" + 
				"      \"Taquaral de Goiás\",\r\n" + 
				"      \"Teresina de Goiás\",\r\n" + 
				"      \"Terezópolis de Goiás\",\r\n" + 
				"      \"Três Ranchos\",\r\n" + 
				"      \"Trindade\",\r\n" + 
				"      \"Trombas\",\r\n" + 
				"      \"Turvânia\",\r\n" + 
				"      \"Turvelândia\",\r\n" + 
				"      \"Uirapuru\",\r\n" + 
				"      \"Uruaçu\",\r\n" + 
				"      \"Uruana\",\r\n" + 
				"      \"Urutaí\",\r\n" + 
				"      \"Valparaíso de Goiás\",\r\n" + 
				"      \"Varjão\",\r\n" + 
				"      \"Vianópolis\",\r\n" + 
				"      \"Vicentinópolis\",\r\n" + 
				"      \"Vila Boa\",\r\n" + 
				"      \"Vila Propício\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"MA\",\r\n" + 
				"    \"nome\": \"Maranhão\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Açailândia\",\r\n" + 
				"      \"Afonso Cunha\",\r\n" + 
				"      \"Água Doce do Maranhão\",\r\n" + 
				"      \"Alcântara\",\r\n" + 
				"      \"Aldeias Altas\",\r\n" + 
				"      \"Altamira do Maranhão\",\r\n" + 
				"      \"Alto Alegre do Maranhão\",\r\n" + 
				"      \"Alto Alegre do Pindaré\",\r\n" + 
				"      \"Alto Parnaíba\",\r\n" + 
				"      \"Amapá do Maranhão\",\r\n" + 
				"      \"Amarante do Maranhão\",\r\n" + 
				"      \"Anajatuba\",\r\n" + 
				"      \"Anapurus\",\r\n" + 
				"      \"Apicum-Açu\",\r\n" + 
				"      \"Araguanã\",\r\n" + 
				"      \"Araioses\",\r\n" + 
				"      \"Arame\",\r\n" + 
				"      \"Arari\",\r\n" + 
				"      \"Axixá\",\r\n" + 
				"      \"Bacabal\",\r\n" + 
				"      \"Bacabeira\",\r\n" + 
				"      \"Bacuri\",\r\n" + 
				"      \"Bacurituba\",\r\n" + 
				"      \"Balsas\",\r\n" + 
				"      \"Barão de Grajaú\",\r\n" + 
				"      \"Barra do Corda\",\r\n" + 
				"      \"Barreirinhas\",\r\n" + 
				"      \"Bela Vista do Maranhão\",\r\n" + 
				"      \"Belágua\",\r\n" + 
				"      \"Benedito Leite\",\r\n" + 
				"      \"Bequimão\",\r\n" + 
				"      \"Bernardo do Mearim\",\r\n" + 
				"      \"Boa Vista do Gurupi\",\r\n" + 
				"      \"Bom Jardim\",\r\n" + 
				"      \"Bom Jesus das Selvas\",\r\n" + 
				"      \"Bom Lugar\",\r\n" + 
				"      \"Brejo\",\r\n" + 
				"      \"Brejo de Areia\",\r\n" + 
				"      \"Buriti\",\r\n" + 
				"      \"Buriti Bravo\",\r\n" + 
				"      \"Buriticupu\",\r\n" + 
				"      \"Buritirana\",\r\n" + 
				"      \"Cachoeira Grande\",\r\n" + 
				"      \"Cajapió\",\r\n" + 
				"      \"Cajari\",\r\n" + 
				"      \"Campestre do Maranhão\",\r\n" + 
				"      \"Cândido Mendes\",\r\n" + 
				"      \"Cantanhede\",\r\n" + 
				"      \"Capinzal do Norte\",\r\n" + 
				"      \"Carolina\",\r\n" + 
				"      \"Carutapera\",\r\n" + 
				"      \"Caxias\",\r\n" + 
				"      \"Cedral\",\r\n" + 
				"      \"Central do Maranhão\",\r\n" + 
				"      \"Centro do Guilherme\",\r\n" + 
				"      \"Centro Novo do Maranhão\",\r\n" + 
				"      \"Chapadinha\",\r\n" + 
				"      \"Cidelândia\",\r\n" + 
				"      \"Codó\",\r\n" + 
				"      \"Coelho Neto\",\r\n" + 
				"      \"Colinas\",\r\n" + 
				"      \"Conceição do Lago-Açu\",\r\n" + 
				"      \"Coroatá\",\r\n" + 
				"      \"Cururupu\",\r\n" + 
				"      \"Davinópolis\",\r\n" + 
				"      \"Dom Pedro\",\r\n" + 
				"      \"Duque Bacelar\",\r\n" + 
				"      \"Esperantinópolis\",\r\n" + 
				"      \"Estreito\",\r\n" + 
				"      \"Feira Nova do Maranhão\",\r\n" + 
				"      \"Fernando Falcão\",\r\n" + 
				"      \"Formosa da Serra Negra\",\r\n" + 
				"      \"Fortaleza dos Nogueiras\",\r\n" + 
				"      \"Fortuna\",\r\n" + 
				"      \"Godofredo Viana\",\r\n" + 
				"      \"Gonçalves Dias\",\r\n" + 
				"      \"Governador Archer\",\r\n" + 
				"      \"Governador Edison Lobão\",\r\n" + 
				"      \"Governador Eugênio Barros\",\r\n" + 
				"      \"Governador Luiz Rocha\",\r\n" + 
				"      \"Governador Newton Bello\",\r\n" + 
				"      \"Governador Nunes Freire\",\r\n" + 
				"      \"Graça Aranha\",\r\n" + 
				"      \"Grajaú\",\r\n" + 
				"      \"Guimarães\",\r\n" + 
				"      \"Humberto de Campos\",\r\n" + 
				"      \"Icatu\",\r\n" + 
				"      \"Igarapé do Meio\",\r\n" + 
				"      \"Igarapé Grande\",\r\n" + 
				"      \"Imperatriz\",\r\n" + 
				"      \"Itaipava do Grajaú\",\r\n" + 
				"      \"Itapecuru Mirim\",\r\n" + 
				"      \"Itinga do Maranhão\",\r\n" + 
				"      \"Jatobá\",\r\n" + 
				"      \"Jenipapo dos Vieiras\",\r\n" + 
				"      \"João Lisboa\",\r\n" + 
				"      \"Joselândia\",\r\n" + 
				"      \"Junco do Maranhão\",\r\n" + 
				"      \"Lago da Pedra\",\r\n" + 
				"      \"Lago do Junco\",\r\n" + 
				"      \"Lago dos Rodrigues\",\r\n" + 
				"      \"Lago Verde\",\r\n" + 
				"      \"Lagoa do Mato\",\r\n" + 
				"      \"Lagoa Grande do Maranhão\",\r\n" + 
				"      \"Lajeado Novo\",\r\n" + 
				"      \"Lima Campos\",\r\n" + 
				"      \"Loreto\",\r\n" + 
				"      \"Luís Domingues\",\r\n" + 
				"      \"Magalhães de Almeida\",\r\n" + 
				"      \"Maracaçumé\",\r\n" + 
				"      \"Marajá do Sena\",\r\n" + 
				"      \"Maranhãozinho\",\r\n" + 
				"      \"Mata Roma\",\r\n" + 
				"      \"Matinha\",\r\n" + 
				"      \"Matões\",\r\n" + 
				"      \"Matões do Norte\",\r\n" + 
				"      \"Milagres do Maranhão\",\r\n" + 
				"      \"Mirador\",\r\n" + 
				"      \"Miranda do Norte\",\r\n" + 
				"      \"Mirinzal\",\r\n" + 
				"      \"Monção\",\r\n" + 
				"      \"Montes Altos\",\r\n" + 
				"      \"Morros\",\r\n" + 
				"      \"Nina Rodrigues\",\r\n" + 
				"      \"Nova Colinas\",\r\n" + 
				"      \"Nova Iorque\",\r\n" + 
				"      \"Nova Olinda do Maranhão\",\r\n" + 
				"      \"Olho d'Água das Cunhãs\",\r\n" + 
				"      \"Olinda Nova do Maranhão\",\r\n" + 
				"      \"Paço do Lumiar\",\r\n" + 
				"      \"Palmeirândia\",\r\n" + 
				"      \"Paraibano\",\r\n" + 
				"      \"Parnarama\",\r\n" + 
				"      \"Passagem Franca\",\r\n" + 
				"      \"Pastos Bons\",\r\n" + 
				"      \"Paulino Neves\",\r\n" + 
				"      \"Paulo Ramos\",\r\n" + 
				"      \"Pedreiras\",\r\n" + 
				"      \"Pedro do Rosário\",\r\n" + 
				"      \"Penalva\",\r\n" + 
				"      \"Peri Mirim\",\r\n" + 
				"      \"Peritoró\",\r\n" + 
				"      \"Pindaré Mirim\",\r\n" + 
				"      \"Pinheiro\",\r\n" + 
				"      \"Pio XII\",\r\n" + 
				"      \"Pirapemas\",\r\n" + 
				"      \"Poção de Pedras\",\r\n" + 
				"      \"Porto Franco\",\r\n" + 
				"      \"Porto Rico do Maranhão\",\r\n" + 
				"      \"Presidente Dutra\",\r\n" + 
				"      \"Presidente Juscelino\",\r\n" + 
				"      \"Presidente Médici\",\r\n" + 
				"      \"Presidente Sarney\",\r\n" + 
				"      \"Presidente Vargas\",\r\n" + 
				"      \"Primeira Cruz\",\r\n" + 
				"      \"Raposa\",\r\n" + 
				"      \"Riachão\",\r\n" + 
				"      \"Ribamar Fiquene\",\r\n" + 
				"      \"Rosário\",\r\n" + 
				"      \"Sambaíba\",\r\n" + 
				"      \"Santa Filomena do Maranhão\",\r\n" + 
				"      \"Santa Helena\",\r\n" + 
				"      \"Santa Inês\",\r\n" + 
				"      \"Santa Luzia\",\r\n" + 
				"      \"Santa Luzia do Paruá\",\r\n" + 
				"      \"Santa Quitéria do Maranhão\",\r\n" + 
				"      \"Santa Rita\",\r\n" + 
				"      \"Santana do Maranhão\",\r\n" + 
				"      \"Santo Amaro do Maranhão\",\r\n" + 
				"      \"Santo Antônio dos Lopes\",\r\n" + 
				"      \"São Benedito do Rio Preto\",\r\n" + 
				"      \"São Bento\",\r\n" + 
				"      \"São Bernardo\",\r\n" + 
				"      \"São Domingos do Azeitão\",\r\n" + 
				"      \"São Domingos do Maranhão\",\r\n" + 
				"      \"São Félix de Balsas\",\r\n" + 
				"      \"São Francisco do Brejão\",\r\n" + 
				"      \"São Francisco do Maranhão\",\r\n" + 
				"      \"São João Batista\",\r\n" + 
				"      \"São João do Carú\",\r\n" + 
				"      \"São João do Paraíso\",\r\n" + 
				"      \"São João do Soter\",\r\n" + 
				"      \"São João dos Patos\",\r\n" + 
				"      \"São José de Ribamar\",\r\n" + 
				"      \"São José dos Basílios\",\r\n" + 
				"      \"São Luís\",\r\n" + 
				"      \"São Luís Gonzaga do Maranhão\",\r\n" + 
				"      \"São Mateus do Maranhão\",\r\n" + 
				"      \"São Pedro da Água Branca\",\r\n" + 
				"      \"São Pedro dos Crentes\",\r\n" + 
				"      \"São Raimundo das Mangabeiras\",\r\n" + 
				"      \"São Raimundo do Doca Bezerra\",\r\n" + 
				"      \"São Roberto\",\r\n" + 
				"      \"São Vicente Ferrer\",\r\n" + 
				"      \"Satubinha\",\r\n" + 
				"      \"Senador Alexandre Costa\",\r\n" + 
				"      \"Senador La Rocque\",\r\n" + 
				"      \"Serrano do Maranhão\",\r\n" + 
				"      \"Sítio Novo\",\r\n" + 
				"      \"Sucupira do Norte\",\r\n" + 
				"      \"Sucupira do Riachão\",\r\n" + 
				"      \"Tasso Fragoso\",\r\n" + 
				"      \"Timbiras\",\r\n" + 
				"      \"Timon\",\r\n" + 
				"      \"Trizidela do Vale\",\r\n" + 
				"      \"Tufilândia\",\r\n" + 
				"      \"Tuntum\",\r\n" + 
				"      \"Turiaçu\",\r\n" + 
				"      \"Turilândia\",\r\n" + 
				"      \"Tutóia\",\r\n" + 
				"      \"Urbano Santos\",\r\n" + 
				"      \"Vargem Grande\",\r\n" + 
				"      \"Viana\",\r\n" + 
				"      \"Vila Nova dos Martírios\",\r\n" + 
				"      \"Vitória do Mearim\",\r\n" + 
				"      \"Vitorino Freire\",\r\n" + 
				"      \"Zé Doca\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"MG\",\r\n" + 
				"    \"nome\": \"Minas Gerais\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Abadia dos Dourados\",\r\n" + 
				"      \"Abaeté\",\r\n" + 
				"      \"Abre Campo\",\r\n" + 
				"      \"Acaiaca\",\r\n" + 
				"      \"Açucena\",\r\n" + 
				"      \"Água Boa\",\r\n" + 
				"      \"Água Comprida\",\r\n" + 
				"      \"Aguanil\",\r\n" + 
				"      \"Águas Formosas\",\r\n" + 
				"      \"Águas Vermelhas\",\r\n" + 
				"      \"Aimorés\",\r\n" + 
				"      \"Aiuruoca\",\r\n" + 
				"      \"Alagoa\",\r\n" + 
				"      \"Albertina\",\r\n" + 
				"      \"Além Paraíba\",\r\n" + 
				"      \"Alfenas\",\r\n" + 
				"      \"Alfredo Vasconcelos\",\r\n" + 
				"      \"Almenara\",\r\n" + 
				"      \"Alpercata\",\r\n" + 
				"      \"Alpinópolis\",\r\n" + 
				"      \"Alterosa\",\r\n" + 
				"      \"Alto Caparaó\",\r\n" + 
				"      \"Alto Jequitibá\",\r\n" + 
				"      \"Alto Rio Doce\",\r\n" + 
				"      \"Alvarenga\",\r\n" + 
				"      \"Alvinópolis\",\r\n" + 
				"      \"Alvorada de Minas\",\r\n" + 
				"      \"Amparo do Serra\",\r\n" + 
				"      \"Andradas\",\r\n" + 
				"      \"Andrelândia\",\r\n" + 
				"      \"Angelândia\",\r\n" + 
				"      \"Antônio Carlos\",\r\n" + 
				"      \"Antônio Dias\",\r\n" + 
				"      \"Antônio Prado de Minas\",\r\n" + 
				"      \"Araçaí\",\r\n" + 
				"      \"Aracitaba\",\r\n" + 
				"      \"Araçuaí\",\r\n" + 
				"      \"Araguari\",\r\n" + 
				"      \"Arantina\",\r\n" + 
				"      \"Araponga\",\r\n" + 
				"      \"Araporã\",\r\n" + 
				"      \"Arapuá\",\r\n" + 
				"      \"Araújos\",\r\n" + 
				"      \"Araxá\",\r\n" + 
				"      \"Arceburgo\",\r\n" + 
				"      \"Arcos\",\r\n" + 
				"      \"Areado\",\r\n" + 
				"      \"Argirita\",\r\n" + 
				"      \"Aricanduva\",\r\n" + 
				"      \"Arinos\",\r\n" + 
				"      \"Astolfo Dutra\",\r\n" + 
				"      \"Ataléia\",\r\n" + 
				"      \"Augusto de Lima\",\r\n" + 
				"      \"Baependi\",\r\n" + 
				"      \"Baldim\",\r\n" + 
				"      \"Bambuí\",\r\n" + 
				"      \"Bandeira\",\r\n" + 
				"      \"Bandeira do Sul\",\r\n" + 
				"      \"Barão de Cocais\",\r\n" + 
				"      \"Barão de Monte Alto\",\r\n" + 
				"      \"Barbacena\",\r\n" + 
				"      \"Barra Longa\",\r\n" + 
				"      \"Barroso\",\r\n" + 
				"      \"Bela Vista de Minas\",\r\n" + 
				"      \"Belmiro Braga\",\r\n" + 
				"      \"Belo Horizonte\",\r\n" + 
				"      \"Belo Oriente\",\r\n" + 
				"      \"Belo Vale\",\r\n" + 
				"      \"Berilo\",\r\n" + 
				"      \"Berizal\",\r\n" + 
				"      \"Bertópolis\",\r\n" + 
				"      \"Betim\",\r\n" + 
				"      \"Bias Fortes\",\r\n" + 
				"      \"Bicas\",\r\n" + 
				"      \"Biquinhas\",\r\n" + 
				"      \"Boa Esperança\",\r\n" + 
				"      \"Bocaina de Minas\",\r\n" + 
				"      \"Bocaiúva\",\r\n" + 
				"      \"Bom Despacho\",\r\n" + 
				"      \"Bom Jardim de Minas\",\r\n" + 
				"      \"Bom Jesus da Penha\",\r\n" + 
				"      \"Bom Jesus do Amparo\",\r\n" + 
				"      \"Bom Jesus do Galho\",\r\n" + 
				"      \"Bom Repouso\",\r\n" + 
				"      \"Bom Sucesso\",\r\n" + 
				"      \"Bonfim\",\r\n" + 
				"      \"Bonfinópolis de Minas\",\r\n" + 
				"      \"Bonito de Minas\",\r\n" + 
				"      \"Borda da Mata\",\r\n" + 
				"      \"Botelhos\",\r\n" + 
				"      \"Botumirim\",\r\n" + 
				"      \"Brás Pires\",\r\n" + 
				"      \"Brasilândia de Minas\",\r\n" + 
				"      \"Brasília de Minas\",\r\n" + 
				"      \"Brasópolis\",\r\n" + 
				"      \"Braúnas\",\r\n" + 
				"      \"Brumadinho\",\r\n" + 
				"      \"Bueno Brandão\",\r\n" + 
				"      \"Buenópolis\",\r\n" + 
				"      \"Bugre\",\r\n" + 
				"      \"Buritis\",\r\n" + 
				"      \"Buritizeiro\",\r\n" + 
				"      \"Cabeceira Grande\",\r\n" + 
				"      \"Cabo Verde\",\r\n" + 
				"      \"Cachoeira da Prata\",\r\n" + 
				"      \"Cachoeira de Minas\",\r\n" + 
				"      \"Cachoeira de Pajeú\",\r\n" + 
				"      \"Cachoeira Dourada\",\r\n" + 
				"      \"Caetanópolis\",\r\n" + 
				"      \"Caeté\",\r\n" + 
				"      \"Caiana\",\r\n" + 
				"      \"Cajuri\",\r\n" + 
				"      \"Caldas\",\r\n" + 
				"      \"Camacho\",\r\n" + 
				"      \"Camanducaia\",\r\n" + 
				"      \"Cambuí\",\r\n" + 
				"      \"Cambuquira\",\r\n" + 
				"      \"Campanário\",\r\n" + 
				"      \"Campanha\",\r\n" + 
				"      \"Campestre\",\r\n" + 
				"      \"Campina Verde\",\r\n" + 
				"      \"Campo Azul\",\r\n" + 
				"      \"Campo Belo\",\r\n" + 
				"      \"Campo do Meio\",\r\n" + 
				"      \"Campo Florido\",\r\n" + 
				"      \"Campos Altos\",\r\n" + 
				"      \"Campos Gerais\",\r\n" + 
				"      \"Cana Verde\",\r\n" + 
				"      \"Canaã\",\r\n" + 
				"      \"Canápolis\",\r\n" + 
				"      \"Candeias\",\r\n" + 
				"      \"Cantagalo\",\r\n" + 
				"      \"Caparaó\",\r\n" + 
				"      \"Capela Nova\",\r\n" + 
				"      \"Capelinha\",\r\n" + 
				"      \"Capetinga\",\r\n" + 
				"      \"Capim Branco\",\r\n" + 
				"      \"Capinópolis\",\r\n" + 
				"      \"Capitão Andrade\",\r\n" + 
				"      \"Capitão Enéas\",\r\n" + 
				"      \"Capitólio\",\r\n" + 
				"      \"Caputira\",\r\n" + 
				"      \"Caraí\",\r\n" + 
				"      \"Caranaíba\",\r\n" + 
				"      \"Carandaí\",\r\n" + 
				"      \"Carangola\",\r\n" + 
				"      \"Caratinga\",\r\n" + 
				"      \"Carbonita\",\r\n" + 
				"      \"Careaçu\",\r\n" + 
				"      \"Carlos Chagas\",\r\n" + 
				"      \"Carmésia\",\r\n" + 
				"      \"Carmo da Cachoeira\",\r\n" + 
				"      \"Carmo da Mata\",\r\n" + 
				"      \"Carmo de Minas\",\r\n" + 
				"      \"Carmo do Cajuru\",\r\n" + 
				"      \"Carmo do Paranaíba\",\r\n" + 
				"      \"Carmo do Rio Claro\",\r\n" + 
				"      \"Carmópolis de Minas\",\r\n" + 
				"      \"Carneirinho\",\r\n" + 
				"      \"Carrancas\",\r\n" + 
				"      \"Carvalhópolis\",\r\n" + 
				"      \"Carvalhos\",\r\n" + 
				"      \"Casa Grande\",\r\n" + 
				"      \"Cascalho Rico\",\r\n" + 
				"      \"Cássia\",\r\n" + 
				"      \"Cataguases\",\r\n" + 
				"      \"Catas Altas\",\r\n" + 
				"      \"Catas Altas da Noruega\",\r\n" + 
				"      \"Catuji\",\r\n" + 
				"      \"Catuti\",\r\n" + 
				"      \"Caxambu\",\r\n" + 
				"      \"Cedro do Abaeté\",\r\n" + 
				"      \"Central de Minas\",\r\n" + 
				"      \"Centralina\",\r\n" + 
				"      \"Chácara\",\r\n" + 
				"      \"Chalé\",\r\n" + 
				"      \"Chapada do Norte\",\r\n" + 
				"      \"Chapada Gaúcha\",\r\n" + 
				"      \"Chiador\",\r\n" + 
				"      \"Cipotânea\",\r\n" + 
				"      \"Claraval\",\r\n" + 
				"      \"Claro dos Poções\",\r\n" + 
				"      \"Cláudio\",\r\n" + 
				"      \"Coimbra\",\r\n" + 
				"      \"Coluna\",\r\n" + 
				"      \"Comendador Gomes\",\r\n" + 
				"      \"Comercinho\",\r\n" + 
				"      \"Conceição da Aparecida\",\r\n" + 
				"      \"Conceição da Barra de Minas\",\r\n" + 
				"      \"Conceição das Alagoas\",\r\n" + 
				"      \"Conceição das Pedras\",\r\n" + 
				"      \"Conceição de Ipanema\",\r\n" + 
				"      \"Conceição do Mato Dentro\",\r\n" + 
				"      \"Conceição do Pará\",\r\n" + 
				"      \"Conceição do Rio Verde\",\r\n" + 
				"      \"Conceição dos Ouros\",\r\n" + 
				"      \"Cônego Marinho\",\r\n" + 
				"      \"Confins\",\r\n" + 
				"      \"Congonhal\",\r\n" + 
				"      \"Congonhas\",\r\n" + 
				"      \"Congonhas do Norte\",\r\n" + 
				"      \"Conquista\",\r\n" + 
				"      \"Conselheiro Lafaiete\",\r\n" + 
				"      \"Conselheiro Pena\",\r\n" + 
				"      \"Consolação\",\r\n" + 
				"      \"Contagem\",\r\n" + 
				"      \"Coqueiral\",\r\n" + 
				"      \"Coração de Jesus\",\r\n" + 
				"      \"Cordisburgo\",\r\n" + 
				"      \"Cordislândia\",\r\n" + 
				"      \"Corinto\",\r\n" + 
				"      \"Coroaci\",\r\n" + 
				"      \"Coromandel\",\r\n" + 
				"      \"Coronel Fabriciano\",\r\n" + 
				"      \"Coronel Murta\",\r\n" + 
				"      \"Coronel Pacheco\",\r\n" + 
				"      \"Coronel Xavier Chaves\",\r\n" + 
				"      \"Córrego Danta\",\r\n" + 
				"      \"Córrego do Bom Jesus\",\r\n" + 
				"      \"Córrego Fundo\",\r\n" + 
				"      \"Córrego Novo\",\r\n" + 
				"      \"Couto de Magalhães de Minas\",\r\n" + 
				"      \"Crisólita\",\r\n" + 
				"      \"Cristais\",\r\n" + 
				"      \"Cristália\",\r\n" + 
				"      \"Cristiano Otoni\",\r\n" + 
				"      \"Cristina\",\r\n" + 
				"      \"Crucilândia\",\r\n" + 
				"      \"Cruzeiro da Fortaleza\",\r\n" + 
				"      \"Cruzília\",\r\n" + 
				"      \"Cuparaque\",\r\n" + 
				"      \"Curral de Dentro\",\r\n" + 
				"      \"Curvelo\",\r\n" + 
				"      \"Datas\",\r\n" + 
				"      \"Delfim Moreira\",\r\n" + 
				"      \"Delfinópolis\",\r\n" + 
				"      \"Delta\",\r\n" + 
				"      \"Descoberto\",\r\n" + 
				"      \"Desterro de Entre Rios\",\r\n" + 
				"      \"Desterro do Melo\",\r\n" + 
				"      \"Diamantina\",\r\n" + 
				"      \"Diogo de Vasconcelos\",\r\n" + 
				"      \"Dionísio\",\r\n" + 
				"      \"Divinésia\",\r\n" + 
				"      \"Divino\",\r\n" + 
				"      \"Divino das Laranjeiras\",\r\n" + 
				"      \"Divinolândia de Minas\",\r\n" + 
				"      \"Divinópolis\",\r\n" + 
				"      \"Divisa Alegre\",\r\n" + 
				"      \"Divisa Nova\",\r\n" + 
				"      \"Divisópolis\",\r\n" + 
				"      \"Dom Bosco\",\r\n" + 
				"      \"Dom Cavati\",\r\n" + 
				"      \"Dom Joaquim\",\r\n" + 
				"      \"Dom Silvério\",\r\n" + 
				"      \"Dom Viçoso\",\r\n" + 
				"      \"Dona Euzébia\",\r\n" + 
				"      \"Dores de Campos\",\r\n" + 
				"      \"Dores de Guanhães\",\r\n" + 
				"      \"Dores do Indaiá\",\r\n" + 
				"      \"Dores do Turvo\",\r\n" + 
				"      \"Doresópolis\",\r\n" + 
				"      \"Douradoquara\",\r\n" + 
				"      \"Durandé\",\r\n" + 
				"      \"Elói Mendes\",\r\n" + 
				"      \"Engenheiro Caldas\",\r\n" + 
				"      \"Engenheiro Navarro\",\r\n" + 
				"      \"Entre Folhas\",\r\n" + 
				"      \"Entre Rios de Minas\",\r\n" + 
				"      \"Ervália\",\r\n" + 
				"      \"Esmeraldas\",\r\n" + 
				"      \"Espera Feliz\",\r\n" + 
				"      \"Espinosa\",\r\n" + 
				"      \"Espírito Santo do Dourado\",\r\n" + 
				"      \"Estiva\",\r\n" + 
				"      \"Estrela Dalva\",\r\n" + 
				"      \"Estrela do Indaiá\",\r\n" + 
				"      \"Estrela do Sul\",\r\n" + 
				"      \"Eugenópolis\",\r\n" + 
				"      \"Ewbank da Câmara\",\r\n" + 
				"      \"Extrema\",\r\n" + 
				"      \"Fama\",\r\n" + 
				"      \"Faria Lemos\",\r\n" + 
				"      \"Felício dos Santos\",\r\n" + 
				"      \"Felisburgo\",\r\n" + 
				"      \"Felixlândia\",\r\n" + 
				"      \"Fernandes Tourinho\",\r\n" + 
				"      \"Ferros\",\r\n" + 
				"      \"Fervedouro\",\r\n" + 
				"      \"Florestal\",\r\n" + 
				"      \"Formiga\",\r\n" + 
				"      \"Formoso\",\r\n" + 
				"      \"Fortaleza de Minas\",\r\n" + 
				"      \"Fortuna de Minas\",\r\n" + 
				"      \"Francisco Badaró\",\r\n" + 
				"      \"Francisco Dumont\",\r\n" + 
				"      \"Francisco Sá\",\r\n" + 
				"      \"Franciscópolis\",\r\n" + 
				"      \"Frei Gaspar\",\r\n" + 
				"      \"Frei Inocêncio\",\r\n" + 
				"      \"Frei Lagonegro\",\r\n" + 
				"      \"Fronteira\",\r\n" + 
				"      \"Fronteira dos Vales\",\r\n" + 
				"      \"Fruta de Leite\",\r\n" + 
				"      \"Frutal\",\r\n" + 
				"      \"Funilândia\",\r\n" + 
				"      \"Galiléia\",\r\n" + 
				"      \"Gameleiras\",\r\n" + 
				"      \"Glaucilândia\",\r\n" + 
				"      \"Goiabeira\",\r\n" + 
				"      \"Goianá\",\r\n" + 
				"      \"Gonçalves\",\r\n" + 
				"      \"Gonzaga\",\r\n" + 
				"      \"Gouveia\",\r\n" + 
				"      \"Governador Valadares\",\r\n" + 
				"      \"Grão Mogol\",\r\n" + 
				"      \"Grupiara\",\r\n" + 
				"      \"Guanhães\",\r\n" + 
				"      \"Guapé\",\r\n" + 
				"      \"Guaraciaba\",\r\n" + 
				"      \"Guaraciama\",\r\n" + 
				"      \"Guaranésia\",\r\n" + 
				"      \"Guarani\",\r\n" + 
				"      \"Guarará\",\r\n" + 
				"      \"Guarda-Mor\",\r\n" + 
				"      \"Guaxupé\",\r\n" + 
				"      \"Guidoval\",\r\n" + 
				"      \"Guimarânia\",\r\n" + 
				"      \"Guiricema\",\r\n" + 
				"      \"Gurinhatã\",\r\n" + 
				"      \"Heliodora\",\r\n" + 
				"      \"Iapu\",\r\n" + 
				"      \"Ibertioga\",\r\n" + 
				"      \"Ibiá\",\r\n" + 
				"      \"Ibiaí\",\r\n" + 
				"      \"Ibiracatu\",\r\n" + 
				"      \"Ibiraci\",\r\n" + 
				"      \"Ibirité\",\r\n" + 
				"      \"Ibitiúra de Minas\",\r\n" + 
				"      \"Ibituruna\",\r\n" + 
				"      \"Icaraí de Minas\",\r\n" + 
				"      \"Igarapé\",\r\n" + 
				"      \"Igaratinga\",\r\n" + 
				"      \"Iguatama\",\r\n" + 
				"      \"Ijaci\",\r\n" + 
				"      \"Ilicínea\",\r\n" + 
				"      \"Imbé de Minas\",\r\n" + 
				"      \"Inconfidentes\",\r\n" + 
				"      \"Indaiabira\",\r\n" + 
				"      \"Indianópolis\",\r\n" + 
				"      \"Ingaí\",\r\n" + 
				"      \"Inhapim\",\r\n" + 
				"      \"Inhaúma\",\r\n" + 
				"      \"Inimutaba\",\r\n" + 
				"      \"Ipaba\",\r\n" + 
				"      \"Ipanema\",\r\n" + 
				"      \"Ipatinga\",\r\n" + 
				"      \"Ipiaçu\",\r\n" + 
				"      \"Ipuiúna\",\r\n" + 
				"      \"Iraí de Minas\",\r\n" + 
				"      \"Itabira\",\r\n" + 
				"      \"Itabirinha de Mantena\",\r\n" + 
				"      \"Itabirito\",\r\n" + 
				"      \"Itacambira\",\r\n" + 
				"      \"Itacarambi\",\r\n" + 
				"      \"Itaguara\",\r\n" + 
				"      \"Itaipé\",\r\n" + 
				"      \"Itajubá\",\r\n" + 
				"      \"Itamarandiba\",\r\n" + 
				"      \"Itamarati de Minas\",\r\n" + 
				"      \"Itambacuri\",\r\n" + 
				"      \"Itambé do Mato Dentro\",\r\n" + 
				"      \"Itamogi\",\r\n" + 
				"      \"Itamonte\",\r\n" + 
				"      \"Itanhandu\",\r\n" + 
				"      \"Itanhomi\",\r\n" + 
				"      \"Itaobim\",\r\n" + 
				"      \"Itapagipe\",\r\n" + 
				"      \"Itapecerica\",\r\n" + 
				"      \"Itapeva\",\r\n" + 
				"      \"Itatiaiuçu\",\r\n" + 
				"      \"Itaú de Minas\",\r\n" + 
				"      \"Itaúna\",\r\n" + 
				"      \"Itaverava\",\r\n" + 
				"      \"Itinga\",\r\n" + 
				"      \"Itueta\",\r\n" + 
				"      \"Ituiutaba\",\r\n" + 
				"      \"Itumirim\",\r\n" + 
				"      \"Iturama\",\r\n" + 
				"      \"Itutinga\",\r\n" + 
				"      \"Jaboticatubas\",\r\n" + 
				"      \"Jacinto\",\r\n" + 
				"      \"Jacuí\",\r\n" + 
				"      \"Jacutinga\",\r\n" + 
				"      \"Jaguaraçu\",\r\n" + 
				"      \"Jaíba\",\r\n" + 
				"      \"Jampruca\",\r\n" + 
				"      \"Janaúba\",\r\n" + 
				"      \"Januária\",\r\n" + 
				"      \"Japaraíba\",\r\n" + 
				"      \"Japonvar\",\r\n" + 
				"      \"Jeceaba\",\r\n" + 
				"      \"Jenipapo de Minas\",\r\n" + 
				"      \"Jequeri\",\r\n" + 
				"      \"Jequitaí\",\r\n" + 
				"      \"Jequitibá\",\r\n" + 
				"      \"Jequitinhonha\",\r\n" + 
				"      \"Jesuânia\",\r\n" + 
				"      \"Joaíma\",\r\n" + 
				"      \"Joanésia\",\r\n" + 
				"      \"João Monlevade\",\r\n" + 
				"      \"João Pinheiro\",\r\n" + 
				"      \"Joaquim Felício\",\r\n" + 
				"      \"Jordânia\",\r\n" + 
				"      \"José Gonçalves de Minas\",\r\n" + 
				"      \"José Raydan\",\r\n" + 
				"      \"Josenópolis\",\r\n" + 
				"      \"Juatuba\",\r\n" + 
				"      \"Juiz de Fora\",\r\n" + 
				"      \"Juramento\",\r\n" + 
				"      \"Juruaia\",\r\n" + 
				"      \"Juvenília\",\r\n" + 
				"      \"Ladainha\",\r\n" + 
				"      \"Lagamar\",\r\n" + 
				"      \"Lagoa da Prata\",\r\n" + 
				"      \"Lagoa dos Patos\",\r\n" + 
				"      \"Lagoa Dourada\",\r\n" + 
				"      \"Lagoa Formosa\",\r\n" + 
				"      \"Lagoa Grande\",\r\n" + 
				"      \"Lagoa Santa\",\r\n" + 
				"      \"Lajinha\",\r\n" + 
				"      \"Lambari\",\r\n" + 
				"      \"Lamim\",\r\n" + 
				"      \"Laranjal\",\r\n" + 
				"      \"Lassance\",\r\n" + 
				"      \"Lavras\",\r\n" + 
				"      \"Leandro Ferreira\",\r\n" + 
				"      \"Leme do Prado\",\r\n" + 
				"      \"Leopoldina\",\r\n" + 
				"      \"Liberdade\",\r\n" + 
				"      \"Lima Duarte\",\r\n" + 
				"      \"Limeira do Oeste\",\r\n" + 
				"      \"Lontra\",\r\n" + 
				"      \"Luisburgo\",\r\n" + 
				"      \"Luislândia\",\r\n" + 
				"      \"Luminárias\",\r\n" + 
				"      \"Luz\",\r\n" + 
				"      \"Machacalis\",\r\n" + 
				"      \"Machado\",\r\n" + 
				"      \"Madre de Deus de Minas\",\r\n" + 
				"      \"Malacacheta\",\r\n" + 
				"      \"Mamonas\",\r\n" + 
				"      \"Manga\",\r\n" + 
				"      \"Manhuaçu\",\r\n" + 
				"      \"Manhumirim\",\r\n" + 
				"      \"Mantena\",\r\n" + 
				"      \"Mar de Espanha\",\r\n" + 
				"      \"Maravilhas\",\r\n" + 
				"      \"Maria da Fé\",\r\n" + 
				"      \"Mariana\",\r\n" + 
				"      \"Marilac\",\r\n" + 
				"      \"Mário Campos\",\r\n" + 
				"      \"Maripá de Minas\",\r\n" + 
				"      \"Marliéria\",\r\n" + 
				"      \"Marmelópolis\",\r\n" + 
				"      \"Martinho Campos\",\r\n" + 
				"      \"Martins Soares\",\r\n" + 
				"      \"Mata Verde\",\r\n" + 
				"      \"Materlândia\",\r\n" + 
				"      \"Mateus Leme\",\r\n" + 
				"      \"Mathias Lobato\",\r\n" + 
				"      \"Matias Barbosa\",\r\n" + 
				"      \"Matias Cardoso\",\r\n" + 
				"      \"Matipó\",\r\n" + 
				"      \"Mato Verde\",\r\n" + 
				"      \"Matozinhos\",\r\n" + 
				"      \"Matutina\",\r\n" + 
				"      \"Medeiros\",\r\n" + 
				"      \"Medina\",\r\n" + 
				"      \"Mendes Pimentel\",\r\n" + 
				"      \"Mercês\",\r\n" + 
				"      \"Mesquita\",\r\n" + 
				"      \"Minas Novas\",\r\n" + 
				"      \"Minduri\",\r\n" + 
				"      \"Mirabela\",\r\n" + 
				"      \"Miradouro\",\r\n" + 
				"      \"Miraí\",\r\n" + 
				"      \"Miravânia\",\r\n" + 
				"      \"Moeda\",\r\n" + 
				"      \"Moema\",\r\n" + 
				"      \"Monjolos\",\r\n" + 
				"      \"Monsenhor Paulo\",\r\n" + 
				"      \"Montalvânia\",\r\n" + 
				"      \"Monte Alegre de Minas\",\r\n" + 
				"      \"Monte Azul\",\r\n" + 
				"      \"Monte Belo\",\r\n" + 
				"      \"Monte Carmelo\",\r\n" + 
				"      \"Monte Formoso\",\r\n" + 
				"      \"Monte Santo de Minas\",\r\n" + 
				"      \"Monte Sião\",\r\n" + 
				"      \"Montes Claros\",\r\n" + 
				"      \"Montezuma\",\r\n" + 
				"      \"Morada Nova de Minas\",\r\n" + 
				"      \"Morro da Garça\",\r\n" + 
				"      \"Morro do Pilar\",\r\n" + 
				"      \"Munhoz\",\r\n" + 
				"      \"Muriaé\",\r\n" + 
				"      \"Mutum\",\r\n" + 
				"      \"Muzambinho\",\r\n" + 
				"      \"Nacip Raydan\",\r\n" + 
				"      \"Nanuque\",\r\n" + 
				"      \"Naque\",\r\n" + 
				"      \"Natalândia\",\r\n" + 
				"      \"Natércia\",\r\n" + 
				"      \"Nazareno\",\r\n" + 
				"      \"Nepomuceno\",\r\n" + 
				"      \"Ninheira\",\r\n" + 
				"      \"Nova Belém\",\r\n" + 
				"      \"Nova Era\",\r\n" + 
				"      \"Nova Lima\",\r\n" + 
				"      \"Nova Módica\",\r\n" + 
				"      \"Nova Ponte\",\r\n" + 
				"      \"Nova Porteirinha\",\r\n" + 
				"      \"Nova Resende\",\r\n" + 
				"      \"Nova Serrana\",\r\n" + 
				"      \"Nova União\",\r\n" + 
				"      \"Novo Cruzeiro\",\r\n" + 
				"      \"Novo Oriente de Minas\",\r\n" + 
				"      \"Novorizonte\",\r\n" + 
				"      \"Olaria\",\r\n" + 
				"      \"Olhos-d'Água\",\r\n" + 
				"      \"Olímpio Noronha\",\r\n" + 
				"      \"Oliveira\",\r\n" + 
				"      \"Oliveira Fortes\",\r\n" + 
				"      \"Onça de Pitangui\",\r\n" + 
				"      \"Oratórios\",\r\n" + 
				"      \"Orizânia\",\r\n" + 
				"      \"Ouro Branco\",\r\n" + 
				"      \"Ouro Fino\",\r\n" + 
				"      \"Ouro Preto\",\r\n" + 
				"      \"Ouro Verde de Minas\",\r\n" + 
				"      \"Padre Carvalho\",\r\n" + 
				"      \"Padre Paraíso\",\r\n" + 
				"      \"Pai Pedro\",\r\n" + 
				"      \"Paineiras\",\r\n" + 
				"      \"Pains\",\r\n" + 
				"      \"Paiva\",\r\n" + 
				"      \"Palma\",\r\n" + 
				"      \"Palmópolis\",\r\n" + 
				"      \"Papagaios\",\r\n" + 
				"      \"Pará de Minas\",\r\n" + 
				"      \"Paracatu\",\r\n" + 
				"      \"Paraguaçu\",\r\n" + 
				"      \"Paraisópolis\",\r\n" + 
				"      \"Paraopeba\",\r\n" + 
				"      \"Passa Quatro\",\r\n" + 
				"      \"Passa Tempo\",\r\n" + 
				"      \"Passa-Vinte\",\r\n" + 
				"      \"Passabém\",\r\n" + 
				"      \"Passos\",\r\n" + 
				"      \"Patis\",\r\n" + 
				"      \"Patos de Minas\",\r\n" + 
				"      \"Patrocínio\",\r\n" + 
				"      \"Patrocínio do Muriaé\",\r\n" + 
				"      \"Paula Cândido\",\r\n" + 
				"      \"Paulistas\",\r\n" + 
				"      \"Pavão\",\r\n" + 
				"      \"Peçanha\",\r\n" + 
				"      \"Pedra Azul\",\r\n" + 
				"      \"Pedra Bonita\",\r\n" + 
				"      \"Pedra do Anta\",\r\n" + 
				"      \"Pedra do Indaiá\",\r\n" + 
				"      \"Pedra Dourada\",\r\n" + 
				"      \"Pedralva\",\r\n" + 
				"      \"Pedras de Maria da Cruz\",\r\n" + 
				"      \"Pedrinópolis\",\r\n" + 
				"      \"Pedro Leopoldo\",\r\n" + 
				"      \"Pedro Teixeira\",\r\n" + 
				"      \"Pequeri\",\r\n" + 
				"      \"Pequi\",\r\n" + 
				"      \"Perdigão\",\r\n" + 
				"      \"Perdizes\",\r\n" + 
				"      \"Perdões\",\r\n" + 
				"      \"Periquito\",\r\n" + 
				"      \"Pescador\",\r\n" + 
				"      \"Piau\",\r\n" + 
				"      \"Piedade de Caratinga\",\r\n" + 
				"      \"Piedade de Ponte Nova\",\r\n" + 
				"      \"Piedade do Rio Grande\",\r\n" + 
				"      \"Piedade dos Gerais\",\r\n" + 
				"      \"Pimenta\",\r\n" + 
				"      \"Pingo-d'Água\",\r\n" + 
				"      \"Pintópolis\",\r\n" + 
				"      \"Piracema\",\r\n" + 
				"      \"Pirajuba\",\r\n" + 
				"      \"Piranga\",\r\n" + 
				"      \"Piranguçu\",\r\n" + 
				"      \"Piranguinho\",\r\n" + 
				"      \"Pirapetinga\",\r\n" + 
				"      \"Pirapora\",\r\n" + 
				"      \"Piraúba\",\r\n" + 
				"      \"Pitangui\",\r\n" + 
				"      \"Piumhi\",\r\n" + 
				"      \"Planura\",\r\n" + 
				"      \"Poço Fundo\",\r\n" + 
				"      \"Poços de Caldas\",\r\n" + 
				"      \"Pocrane\",\r\n" + 
				"      \"Pompéu\",\r\n" + 
				"      \"Ponte Nova\",\r\n" + 
				"      \"Ponto Chique\",\r\n" + 
				"      \"Ponto dos Volantes\",\r\n" + 
				"      \"Porteirinha\",\r\n" + 
				"      \"Porto Firme\",\r\n" + 
				"      \"Poté\",\r\n" + 
				"      \"Pouso Alegre\",\r\n" + 
				"      \"Pouso Alto\",\r\n" + 
				"      \"Prados\",\r\n" + 
				"      \"Prata\",\r\n" + 
				"      \"Pratápolis\",\r\n" + 
				"      \"Pratinha\",\r\n" + 
				"      \"Presidente Bernardes\",\r\n" + 
				"      \"Presidente Juscelino\",\r\n" + 
				"      \"Presidente Kubitschek\",\r\n" + 
				"      \"Presidente Olegário\",\r\n" + 
				"      \"Prudente de Morais\",\r\n" + 
				"      \"Quartel Geral\",\r\n" + 
				"      \"Queluzito\",\r\n" + 
				"      \"Raposos\",\r\n" + 
				"      \"Raul Soares\",\r\n" + 
				"      \"Recreio\",\r\n" + 
				"      \"Reduto\",\r\n" + 
				"      \"Resende Costa\",\r\n" + 
				"      \"Resplendor\",\r\n" + 
				"      \"Ressaquinha\",\r\n" + 
				"      \"Riachinho\",\r\n" + 
				"      \"Riacho dos Machados\",\r\n" + 
				"      \"Ribeirão das Neves\",\r\n" + 
				"      \"Ribeirão Vermelho\",\r\n" + 
				"      \"Rio Acima\",\r\n" + 
				"      \"Rio Casca\",\r\n" + 
				"      \"Rio do Prado\",\r\n" + 
				"      \"Rio Doce\",\r\n" + 
				"      \"Rio Espera\",\r\n" + 
				"      \"Rio Manso\",\r\n" + 
				"      \"Rio Novo\",\r\n" + 
				"      \"Rio Paranaíba\",\r\n" + 
				"      \"Rio Pardo de Minas\",\r\n" + 
				"      \"Rio Piracicaba\",\r\n" + 
				"      \"Rio Pomba\",\r\n" + 
				"      \"Rio Preto\",\r\n" + 
				"      \"Rio Vermelho\",\r\n" + 
				"      \"Ritápolis\",\r\n" + 
				"      \"Rochedo de Minas\",\r\n" + 
				"      \"Rodeiro\",\r\n" + 
				"      \"Romaria\",\r\n" + 
				"      \"Rosário da Limeira\",\r\n" + 
				"      \"Rubelita\",\r\n" + 
				"      \"Rubim\",\r\n" + 
				"      \"Sabará\",\r\n" + 
				"      \"Sabinópolis\",\r\n" + 
				"      \"Sacramento\",\r\n" + 
				"      \"Salinas\",\r\n" + 
				"      \"Salto da Divisa\",\r\n" + 
				"      \"Santa Bárbara\",\r\n" + 
				"      \"Santa Bárbara do Leste\",\r\n" + 
				"      \"Santa Bárbara do Monte Verde\",\r\n" + 
				"      \"Santa Bárbara do Tugúrio\",\r\n" + 
				"      \"Santa Cruz de Minas\",\r\n" + 
				"      \"Santa Cruz de Salinas\",\r\n" + 
				"      \"Santa Cruz do Escalvado\",\r\n" + 
				"      \"Santa Efigênia de Minas\",\r\n" + 
				"      \"Santa Fé de Minas\",\r\n" + 
				"      \"Santa Helena de Minas\",\r\n" + 
				"      \"Santa Juliana\",\r\n" + 
				"      \"Santa Luzia\",\r\n" + 
				"      \"Santa Margarida\",\r\n" + 
				"      \"Santa Maria de Itabira\",\r\n" + 
				"      \"Santa Maria do Salto\",\r\n" + 
				"      \"Santa Maria do Suaçuí\",\r\n" + 
				"      \"Santa Rita de Caldas\",\r\n" + 
				"      \"Santa Rita de Ibitipoca\",\r\n" + 
				"      \"Santa Rita de Jacutinga\",\r\n" + 
				"      \"Santa Rita de Minas\",\r\n" + 
				"      \"Santa Rita do Itueto\",\r\n" + 
				"      \"Santa Rita do Sapucaí\",\r\n" + 
				"      \"Santa Rosa da Serra\",\r\n" + 
				"      \"Santa Vitória\",\r\n" + 
				"      \"Santana da Vargem\",\r\n" + 
				"      \"Santana de Cataguases\",\r\n" + 
				"      \"Santana de Pirapama\",\r\n" + 
				"      \"Santana do Deserto\",\r\n" + 
				"      \"Santana do Garambéu\",\r\n" + 
				"      \"Santana do Jacaré\",\r\n" + 
				"      \"Santana do Manhuaçu\",\r\n" + 
				"      \"Santana do Paraíso\",\r\n" + 
				"      \"Santana do Riacho\",\r\n" + 
				"      \"Santana dos Montes\",\r\n" + 
				"      \"Santo Antônio do Amparo\",\r\n" + 
				"      \"Santo Antônio do Aventureiro\",\r\n" + 
				"      \"Santo Antônio do Grama\",\r\n" + 
				"      \"Santo Antônio do Itambé\",\r\n" + 
				"      \"Santo Antônio do Jacinto\",\r\n" + 
				"      \"Santo Antônio do Monte\",\r\n" + 
				"      \"Santo Antônio do Retiro\",\r\n" + 
				"      \"Santo Antônio do Rio Abaixo\",\r\n" + 
				"      \"Santo Hipólito\",\r\n" + 
				"      \"Santos Dumont\",\r\n" + 
				"      \"São Bento Abade\",\r\n" + 
				"      \"São Brás do Suaçuí\",\r\n" + 
				"      \"São Domingos das Dores\",\r\n" + 
				"      \"São Domingos do Prata\",\r\n" + 
				"      \"São Félix de Minas\",\r\n" + 
				"      \"São Francisco\",\r\n" + 
				"      \"São Francisco de Paula\",\r\n" + 
				"      \"São Francisco de Sales\",\r\n" + 
				"      \"São Francisco do Glória\",\r\n" + 
				"      \"São Geraldo\",\r\n" + 
				"      \"São Geraldo da Piedade\",\r\n" + 
				"      \"São Geraldo do Baixio\",\r\n" + 
				"      \"São Gonçalo do Abaeté\",\r\n" + 
				"      \"São Gonçalo do Pará\",\r\n" + 
				"      \"São Gonçalo do Rio Abaixo\",\r\n" + 
				"      \"São Gonçalo do Rio Preto\",\r\n" + 
				"      \"São Gonçalo do Sapucaí\",\r\n" + 
				"      \"São Gotardo\",\r\n" + 
				"      \"São João Batista do Glória\",\r\n" + 
				"      \"São João da Lagoa\",\r\n" + 
				"      \"São João da Mata\",\r\n" + 
				"      \"São João da Ponte\",\r\n" + 
				"      \"São João das Missões\",\r\n" + 
				"      \"São João del Rei\",\r\n" + 
				"      \"São João do Manhuaçu\",\r\n" + 
				"      \"São João do Manteninha\",\r\n" + 
				"      \"São João do Oriente\",\r\n" + 
				"      \"São João do Pacuí\",\r\n" + 
				"      \"São João do Paraíso\",\r\n" + 
				"      \"São João Evangelista\",\r\n" + 
				"      \"São João Nepomuceno\",\r\n" + 
				"      \"São Joaquim de Bicas\",\r\n" + 
				"      \"São José da Barra\",\r\n" + 
				"      \"São José da Lapa\",\r\n" + 
				"      \"São José da Safira\",\r\n" + 
				"      \"São José da Varginha\",\r\n" + 
				"      \"São José do Alegre\",\r\n" + 
				"      \"São José do Divino\",\r\n" + 
				"      \"São José do Goiabal\",\r\n" + 
				"      \"São José do Jacuri\",\r\n" + 
				"      \"São José do Mantimento\",\r\n" + 
				"      \"São Lourenço\",\r\n" + 
				"      \"São Miguel do Anta\",\r\n" + 
				"      \"São Pedro da União\",\r\n" + 
				"      \"São Pedro do Suaçuí\",\r\n" + 
				"      \"São Pedro dos Ferros\",\r\n" + 
				"      \"São Romão\",\r\n" + 
				"      \"São Roque de Minas\",\r\n" + 
				"      \"São Sebastião da Bela Vista\",\r\n" + 
				"      \"São Sebastião da Vargem Alegre\",\r\n" + 
				"      \"São Sebastião do Anta\",\r\n" + 
				"      \"São Sebastião do Maranhão\",\r\n" + 
				"      \"São Sebastião do Oeste\",\r\n" + 
				"      \"São Sebastião do Paraíso\",\r\n" + 
				"      \"São Sebastião do Rio Preto\",\r\n" + 
				"      \"São Sebastião do Rio Verde\",\r\n" + 
				"      \"São Thomé das Letras\",\r\n" + 
				"      \"São Tiago\",\r\n" + 
				"      \"São Tomás de Aquino\",\r\n" + 
				"      \"São Vicente de Minas\",\r\n" + 
				"      \"Sapucaí-Mirim\",\r\n" + 
				"      \"Sardoá\",\r\n" + 
				"      \"Sarzedo\",\r\n" + 
				"      \"Sem-Peixe\",\r\n" + 
				"      \"Senador Amaral\",\r\n" + 
				"      \"Senador Cortes\",\r\n" + 
				"      \"Senador Firmino\",\r\n" + 
				"      \"Senador José Bento\",\r\n" + 
				"      \"Senador Modestino Gonçalves\",\r\n" + 
				"      \"Senhora de Oliveira\",\r\n" + 
				"      \"Senhora do Porto\",\r\n" + 
				"      \"Senhora dos Remédios\",\r\n" + 
				"      \"Sericita\",\r\n" + 
				"      \"Seritinga\",\r\n" + 
				"      \"Serra Azul de Minas\",\r\n" + 
				"      \"Serra da Saudade\",\r\n" + 
				"      \"Serra do Salitre\",\r\n" + 
				"      \"Serra dos Aimorés\",\r\n" + 
				"      \"Serrania\",\r\n" + 
				"      \"Serranópolis de Minas\",\r\n" + 
				"      \"Serranos\",\r\n" + 
				"      \"Serro\",\r\n" + 
				"      \"Sete Lagoas\",\r\n" + 
				"      \"Setubinha\",\r\n" + 
				"      \"Silveirânia\",\r\n" + 
				"      \"Silvianópolis\",\r\n" + 
				"      \"Simão Pereira\",\r\n" + 
				"      \"Simonésia\",\r\n" + 
				"      \"Sobrália\",\r\n" + 
				"      \"Soledade de Minas\",\r\n" + 
				"      \"Tabuleiro\",\r\n" + 
				"      \"Taiobeiras\",\r\n" + 
				"      \"Taparuba\",\r\n" + 
				"      \"Tapira\",\r\n" + 
				"      \"Tapiraí\",\r\n" + 
				"      \"Taquaraçu de Minas\",\r\n" + 
				"      \"Tarumirim\",\r\n" + 
				"      \"Teixeiras\",\r\n" + 
				"      \"Teófilo Otoni\",\r\n" + 
				"      \"Timóteo\",\r\n" + 
				"      \"Tiradentes\",\r\n" + 
				"      \"Tiros\",\r\n" + 
				"      \"Tocantins\",\r\n" + 
				"      \"Tocos do Moji\",\r\n" + 
				"      \"Toledo\",\r\n" + 
				"      \"Tombos\",\r\n" + 
				"      \"Três Corações\",\r\n" + 
				"      \"Três Marias\",\r\n" + 
				"      \"Três Pontas\",\r\n" + 
				"      \"Tumiritinga\",\r\n" + 
				"      \"Tupaciguara\",\r\n" + 
				"      \"Turmalina\",\r\n" + 
				"      \"Turvolândia\",\r\n" + 
				"      \"Ubá\",\r\n" + 
				"      \"Ubaí\",\r\n" + 
				"      \"Ubaporanga\",\r\n" + 
				"      \"Uberaba\",\r\n" + 
				"      \"Uberlândia\",\r\n" + 
				"      \"Umburatiba\",\r\n" + 
				"      \"Unaí\",\r\n" + 
				"      \"União de Minas\",\r\n" + 
				"      \"Uruana de Minas\",\r\n" + 
				"      \"Urucânia\",\r\n" + 
				"      \"Urucuia\",\r\n" + 
				"      \"Vargem Alegre\",\r\n" + 
				"      \"Vargem Bonita\",\r\n" + 
				"      \"Vargem Grande do Rio Pardo\",\r\n" + 
				"      \"Varginha\",\r\n" + 
				"      \"Varjão de Minas\",\r\n" + 
				"      \"Várzea da Palma\",\r\n" + 
				"      \"Varzelândia\",\r\n" + 
				"      \"Vazante\",\r\n" + 
				"      \"Verdelândia\",\r\n" + 
				"      \"Veredinha\",\r\n" + 
				"      \"Veríssimo\",\r\n" + 
				"      \"Vermelho Novo\",\r\n" + 
				"      \"Vespasiano\",\r\n" + 
				"      \"Viçosa\",\r\n" + 
				"      \"Vieiras\",\r\n" + 
				"      \"Virgem da Lapa\",\r\n" + 
				"      \"Virgínia\",\r\n" + 
				"      \"Virginópolis\",\r\n" + 
				"      \"Virgolândia\",\r\n" + 
				"      \"Visconde do Rio Branco\",\r\n" + 
				"      \"Volta Grande\",\r\n" + 
				"      \"Wenceslau Braz\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"MS\",\r\n" + 
				"    \"nome\": \"Mato Grosso do Sul\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Água Clara\",\r\n" + 
				"      \"Alcinópolis\",\r\n" + 
				"      \"Amambaí\",\r\n" + 
				"      \"Anastácio\",\r\n" + 
				"      \"Anaurilândia\",\r\n" + 
				"      \"Angélica\",\r\n" + 
				"      \"Antônio João\",\r\n" + 
				"      \"Aparecida do Taboado\",\r\n" + 
				"      \"Aquidauana\",\r\n" + 
				"      \"Aral Moreira\",\r\n" + 
				"      \"Bandeirantes\",\r\n" + 
				"      \"Bataguassu\",\r\n" + 
				"      \"Bataiporã\",\r\n" + 
				"      \"Bela Vista\",\r\n" + 
				"      \"Bodoquena\",\r\n" + 
				"      \"Bonito\",\r\n" + 
				"      \"Brasilândia\",\r\n" + 
				"      \"Caarapó\",\r\n" + 
				"      \"Camapuã\",\r\n" + 
				"      \"Campo Grande\",\r\n" + 
				"      \"Caracol\",\r\n" + 
				"      \"Cassilândia\",\r\n" + 
				"      \"Chapadão do Sul\",\r\n" + 
				"      \"Corguinho\",\r\n" + 
				"      \"Coronel Sapucaia\",\r\n" + 
				"      \"Corumbá\",\r\n" + 
				"      \"Costa Rica\",\r\n" + 
				"      \"Coxim\",\r\n" + 
				"      \"Deodápolis\",\r\n" + 
				"      \"Dois Irmãos do Buriti\",\r\n" + 
				"      \"Douradina\",\r\n" + 
				"      \"Dourados\",\r\n" + 
				"      \"Eldorado\",\r\n" + 
				"      \"Fátima do Sul\",\r\n" + 
				"      \"Glória de Dourados\",\r\n" + 
				"      \"Guia Lopes da Laguna\",\r\n" + 
				"      \"Iguatemi\",\r\n" + 
				"      \"Inocência\",\r\n" + 
				"      \"Itaporã\",\r\n" + 
				"      \"Itaquiraí\",\r\n" + 
				"      \"Ivinhema\",\r\n" + 
				"      \"Japorã\",\r\n" + 
				"      \"Jaraguari\",\r\n" + 
				"      \"Jardim\",\r\n" + 
				"      \"Jateí\",\r\n" + 
				"      \"Juti\",\r\n" + 
				"      \"Ladário\",\r\n" + 
				"      \"Laguna Carapã\",\r\n" + 
				"      \"Maracaju\",\r\n" + 
				"      \"Miranda\",\r\n" + 
				"      \"Mundo Novo\",\r\n" + 
				"      \"Naviraí\",\r\n" + 
				"      \"Nioaque\",\r\n" + 
				"      \"Nova Alvorada do Sul\",\r\n" + 
				"      \"Nova Andradina\",\r\n" + 
				"      \"Novo Horizonte do Sul\",\r\n" + 
				"      \"Paranaíba\",\r\n" + 
				"      \"Paranhos\",\r\n" + 
				"      \"Pedro Gomes\",\r\n" + 
				"      \"Ponta Porã\",\r\n" + 
				"      \"Porto Murtinho\",\r\n" + 
				"      \"Ribas do Rio Pardo\",\r\n" + 
				"      \"Rio Brilhante\",\r\n" + 
				"      \"Rio Negro\",\r\n" + 
				"      \"Rio Verde de Mato Grosso\",\r\n" + 
				"      \"Rochedo\",\r\n" + 
				"      \"Santa Rita do Pardo\",\r\n" + 
				"      \"São Gabriel do Oeste\",\r\n" + 
				"      \"Selvíria\",\r\n" + 
				"      \"Sete Quedas\",\r\n" + 
				"      \"Sidrolândia\",\r\n" + 
				"      \"Sonora\",\r\n" + 
				"      \"Tacuru\",\r\n" + 
				"      \"Taquarussu\",\r\n" + 
				"      \"Terenos\",\r\n" + 
				"      \"Três Lagoas\",\r\n" + 
				"      \"Vicentina\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"MT\",\r\n" + 
				"    \"nome\": \"Mato Grosso\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Acorizal\",\r\n" + 
				"      \"Água Boa\",\r\n" + 
				"      \"Alta Floresta\",\r\n" + 
				"      \"Alto Araguaia\",\r\n" + 
				"      \"Alto Boa Vista\",\r\n" + 
				"      \"Alto Garças\",\r\n" + 
				"      \"Alto Paraguai\",\r\n" + 
				"      \"Alto Taquari\",\r\n" + 
				"      \"Apiacás\",\r\n" + 
				"      \"Araguaiana\",\r\n" + 
				"      \"Araguainha\",\r\n" + 
				"      \"Araputanga\",\r\n" + 
				"      \"Arenápolis\",\r\n" + 
				"      \"Aripuanã\",\r\n" + 
				"      \"Barão de Melgaço\",\r\n" + 
				"      \"Barra do Bugres\",\r\n" + 
				"      \"Barra do Garças\",\r\n" + 
				"      \"Bom Jesus do Araguaia\",\r\n" + 
				"      \"Brasnorte\",\r\n" + 
				"      \"Cáceres\",\r\n" + 
				"      \"Campinápolis\",\r\n" + 
				"      \"Campo Novo do Parecis\",\r\n" + 
				"      \"Campo Verde\",\r\n" + 
				"      \"Campos de Júlio\",\r\n" + 
				"      \"Canabrava do Norte\",\r\n" + 
				"      \"Canarana\",\r\n" + 
				"      \"Carlinda\",\r\n" + 
				"      \"Castanheira\",\r\n" + 
				"      \"Chapada dos Guimarães\",\r\n" + 
				"      \"Cláudia\",\r\n" + 
				"      \"Cocalinho\",\r\n" + 
				"      \"Colíder\",\r\n" + 
				"      \"Colniza\",\r\n" + 
				"      \"Comodoro\",\r\n" + 
				"      \"Confresa\",\r\n" + 
				"      \"Conquista d'Oeste\",\r\n" + 
				"      \"Cotriguaçu\",\r\n" + 
				"      \"Curvelândia\",\r\n" + 
				"      \"Cuiabá\",\r\n" + 
				"      \"Denise\",\r\n" + 
				"      \"Diamantino\",\r\n" + 
				"      \"Dom Aquino\",\r\n" + 
				"      \"Feliz Natal\",\r\n" + 
				"      \"Figueirópolis d'Oeste\",\r\n" + 
				"      \"Gaúcha do Norte\",\r\n" + 
				"      \"General Carneiro\",\r\n" + 
				"      \"Glória d'Oeste\",\r\n" + 
				"      \"Guarantã do Norte\",\r\n" + 
				"      \"Guiratinga\",\r\n" + 
				"      \"Indiavaí\",\r\n" + 
				"      \"Itaúba\",\r\n" + 
				"      \"Itiquira\",\r\n" + 
				"      \"Jaciara\",\r\n" + 
				"      \"Jangada\",\r\n" + 
				"      \"Jauru\",\r\n" + 
				"      \"Juara\",\r\n" + 
				"      \"Juína\",\r\n" + 
				"      \"Juruena\",\r\n" + 
				"      \"Juscimeira\",\r\n" + 
				"      \"Lambari d'Oeste\",\r\n" + 
				"      \"Lucas do Rio Verde\",\r\n" + 
				"      \"Luciára\",\r\n" + 
				"      \"Marcelândia\",\r\n" + 
				"      \"Matupá\",\r\n" + 
				"      \"Mirassol d'Oeste\",\r\n" + 
				"      \"Nobres\",\r\n" + 
				"      \"Nortelândia\",\r\n" + 
				"      \"Nossa Senhora do Livramento\",\r\n" + 
				"      \"Nova Bandeirantes\",\r\n" + 
				"      \"Nova Brasilândia\",\r\n" + 
				"      \"Nova Canãa do Norte\",\r\n" + 
				"      \"Nova Guarita\",\r\n" + 
				"      \"Nova Lacerda\",\r\n" + 
				"      \"Nova Marilândia\",\r\n" + 
				"      \"Nova Maringá\",\r\n" + 
				"      \"Nova Monte Verde\",\r\n" + 
				"      \"Nova Mutum\",\r\n" + 
				"      \"Nova Nazaré\",\r\n" + 
				"      \"Nova Olímpia\",\r\n" + 
				"      \"Nova Santa Helena\",\r\n" + 
				"      \"Nova Ubiratã\",\r\n" + 
				"      \"Nova Xavantina\",\r\n" + 
				"      \"Novo Horizonte do Norte\",\r\n" + 
				"      \"Novo Mundo\",\r\n" + 
				"      \"Novo Santo Antônio\",\r\n" + 
				"      \"Novo São Joaquim\",\r\n" + 
				"      \"Paranaíta\",\r\n" + 
				"      \"Paranatinga\",\r\n" + 
				"      \"Pedra Preta\",\r\n" + 
				"      \"Peixoto de Azevedo\",\r\n" + 
				"      \"Planalto da Serra\",\r\n" + 
				"      \"Poconé\",\r\n" + 
				"      \"Pontal do Araguaia\",\r\n" + 
				"      \"Ponte Branca\",\r\n" + 
				"      \"Pontes e Lacerda\",\r\n" + 
				"      \"Porto Alegre do Norte\",\r\n" + 
				"      \"Porto dos Gaúchos\",\r\n" + 
				"      \"Porto Esperidião\",\r\n" + 
				"      \"Porto Estrela\",\r\n" + 
				"      \"Poxoréo\",\r\n" + 
				"      \"Primavera do Leste\",\r\n" + 
				"      \"Querência\",\r\n" + 
				"      \"Reserva do Cabaçal\",\r\n" + 
				"      \"Ribeirão Cascalheira\",\r\n" + 
				"      \"Ribeirãozinho\",\r\n" + 
				"      \"Rio Branco\",\r\n" + 
				"      \"Rondolândia\",\r\n" + 
				"      \"Rondonópolis\",\r\n" + 
				"      \"Rosário Oeste\",\r\n" + 
				"      \"Salto do Céu\",\r\n" + 
				"      \"Santa Carmem\",\r\n" + 
				"      \"Santa Cruz do Xingu\",\r\n" + 
				"      \"Santa Rita do Trivelato\",\r\n" + 
				"      \"Santa Terezinha\",\r\n" + 
				"      \"Santo Afonso\",\r\n" + 
				"      \"Santo Antônio do Leste\",\r\n" + 
				"      \"Santo Antônio do Leverger\",\r\n" + 
				"      \"São Félix do Araguaia\",\r\n" + 
				"      \"São José do Povo\",\r\n" + 
				"      \"São José do Rio Claro\",\r\n" + 
				"      \"São José do Xingu\",\r\n" + 
				"      \"São José dos Quatro Marcos\",\r\n" + 
				"      \"São Pedro da Cipa\",\r\n" + 
				"      \"Sapezal\",\r\n" + 
				"      \"Serra Nova Dourada\",\r\n" + 
				"      \"Sinop\",\r\n" + 
				"      \"Sorriso\",\r\n" + 
				"      \"Tabaporã\",\r\n" + 
				"      \"Tangará da Serra\",\r\n" + 
				"      \"Tapurah\",\r\n" + 
				"      \"Terra Nova do Norte\",\r\n" + 
				"      \"Tesouro\",\r\n" + 
				"      \"Torixoréu\",\r\n" + 
				"      \"União do Sul\",\r\n" + 
				"      \"Vale de São Domingos\",\r\n" + 
				"      \"Várzea Grande\",\r\n" + 
				"      \"Vera\",\r\n" + 
				"      \"Vila Bela da Santíssima Trindade\",\r\n" + 
				"      \"Vila Rica\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"PA\",\r\n" + 
				"    \"nome\": \"Pará\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Abaetetuba\",\r\n" + 
				"      \"Abel Figueiredo\",\r\n" + 
				"      \"Acará\",\r\n" + 
				"      \"Afuá\",\r\n" + 
				"      \"Água Azul do Norte\",\r\n" + 
				"      \"Alenquer\",\r\n" + 
				"      \"Almeirim\",\r\n" + 
				"      \"Altamira\",\r\n" + 
				"      \"Anajás\",\r\n" + 
				"      \"Ananindeua\",\r\n" + 
				"      \"Anapu\",\r\n" + 
				"      \"Augusto Corrêa\",\r\n" + 
				"      \"Aurora do Pará\",\r\n" + 
				"      \"Aveiro\",\r\n" + 
				"      \"Bagre\",\r\n" + 
				"      \"Baião\",\r\n" + 
				"      \"Bannach\",\r\n" + 
				"      \"Barcarena\",\r\n" + 
				"      \"Belém\",\r\n" + 
				"      \"Belterra\",\r\n" + 
				"      \"Benevides\",\r\n" + 
				"      \"Bom Jesus do Tocantins\",\r\n" + 
				"      \"Bonito\",\r\n" + 
				"      \"Bragança\",\r\n" + 
				"      \"Brasil Novo\",\r\n" + 
				"      \"Brejo Grande do Araguaia\",\r\n" + 
				"      \"Breu Branco\",\r\n" + 
				"      \"Breves\",\r\n" + 
				"      \"Bujaru\",\r\n" + 
				"      \"Cachoeira do Arari\",\r\n" + 
				"      \"Cachoeira do Piriá\",\r\n" + 
				"      \"Cametá\",\r\n" + 
				"      \"Canaã dos Carajás\",\r\n" + 
				"      \"Capanema\",\r\n" + 
				"      \"Capitão Poço\",\r\n" + 
				"      \"Castanhal\",\r\n" + 
				"      \"Chaves\",\r\n" + 
				"      \"Colares\",\r\n" + 
				"      \"Conceição do Araguaia\",\r\n" + 
				"      \"Concórdia do Pará\",\r\n" + 
				"      \"Cumaru do Norte\",\r\n" + 
				"      \"Curionópolis\",\r\n" + 
				"      \"Curralinho\",\r\n" + 
				"      \"Curuá\",\r\n" + 
				"      \"Curuçá\",\r\n" + 
				"      \"Dom Eliseu\",\r\n" + 
				"      \"Eldorado dos Carajás\",\r\n" + 
				"      \"Faro\",\r\n" + 
				"      \"Floresta do Araguaia\",\r\n" + 
				"      \"Garrafão do Norte\",\r\n" + 
				"      \"Goianésia do Pará\",\r\n" + 
				"      \"Gurupá\",\r\n" + 
				"      \"Igarapé-Açu\",\r\n" + 
				"      \"Igarapé-Miri\",\r\n" + 
				"      \"Inhangapi\",\r\n" + 
				"      \"Ipixuna do Pará\",\r\n" + 
				"      \"Irituia\",\r\n" + 
				"      \"Itaituba\",\r\n" + 
				"      \"Itupiranga\",\r\n" + 
				"      \"Jacareacanga\",\r\n" + 
				"      \"Jacundá\",\r\n" + 
				"      \"Juruti\",\r\n" + 
				"      \"Limoeiro do Ajuru\",\r\n" + 
				"      \"Mãe do Rio\",\r\n" + 
				"      \"Magalhães Barata\",\r\n" + 
				"      \"Marabá\",\r\n" + 
				"      \"Maracanã\",\r\n" + 
				"      \"Marapanim\",\r\n" + 
				"      \"Marituba\",\r\n" + 
				"      \"Medicilândia\",\r\n" + 
				"      \"Melgaço\",\r\n" + 
				"      \"Mocajuba\",\r\n" + 
				"      \"Moju\",\r\n" + 
				"      \"Monte Alegre\",\r\n" + 
				"      \"Muaná\",\r\n" + 
				"      \"Nova Esperança do Piriá\",\r\n" + 
				"      \"Nova Ipixuna\",\r\n" + 
				"      \"Nova Timboteua\",\r\n" + 
				"      \"Novo Progresso\",\r\n" + 
				"      \"Novo Repartimento\",\r\n" + 
				"      \"Óbidos\",\r\n" + 
				"      \"Oeiras do Pará\",\r\n" + 
				"      \"Oriximiná\",\r\n" + 
				"      \"Ourém\",\r\n" + 
				"      \"Ourilândia do Norte\",\r\n" + 
				"      \"Pacajá\",\r\n" + 
				"      \"Palestina do Pará\",\r\n" + 
				"      \"Paragominas\",\r\n" + 
				"      \"Parauapebas\",\r\n" + 
				"      \"Pau d'Arco\",\r\n" + 
				"      \"Peixe-Boi\",\r\n" + 
				"      \"Piçarra\",\r\n" + 
				"      \"Placas\",\r\n" + 
				"      \"Ponta de Pedras\",\r\n" + 
				"      \"Portel\",\r\n" + 
				"      \"Porto de Moz\",\r\n" + 
				"      \"Prainha\",\r\n" + 
				"      \"Primavera\",\r\n" + 
				"      \"Quatipuru\",\r\n" + 
				"      \"Redenção\",\r\n" + 
				"      \"Rio Maria\",\r\n" + 
				"      \"Rondon do Pará\",\r\n" + 
				"      \"Rurópolis\",\r\n" + 
				"      \"Salinópolis\",\r\n" + 
				"      \"Salvaterra\",\r\n" + 
				"      \"Santa Bárbara do Pará\",\r\n" + 
				"      \"Santa Cruz do Arari\",\r\n" + 
				"      \"Santa Isabel do Pará\",\r\n" + 
				"      \"Santa Luzia do Pará\",\r\n" + 
				"      \"Santa Maria das Barreiras\",\r\n" + 
				"      \"Santa Maria do Pará\",\r\n" + 
				"      \"Santana do Araguaia\",\r\n" + 
				"      \"Santarém\",\r\n" + 
				"      \"Santarém Novo\",\r\n" + 
				"      \"Santo Antônio do Tauá\",\r\n" + 
				"      \"São Caetano de Odivela\",\r\n" + 
				"      \"São Domingos do Araguaia\",\r\n" + 
				"      \"São Domingos do Capim\",\r\n" + 
				"      \"São Félix do Xingu\",\r\n" + 
				"      \"São Francisco do Pará\",\r\n" + 
				"      \"São Geraldo do Araguaia\",\r\n" + 
				"      \"São João da Ponta\",\r\n" + 
				"      \"São João de Pirabas\",\r\n" + 
				"      \"São João do Araguaia\",\r\n" + 
				"      \"São Miguel do Guamá\",\r\n" + 
				"      \"São Sebastião da Boa Vista\",\r\n" + 
				"      \"Sapucaia\",\r\n" + 
				"      \"Senador José Porfírio\",\r\n" + 
				"      \"Soure\",\r\n" + 
				"      \"Tailândia\",\r\n" + 
				"      \"Terra Alta\",\r\n" + 
				"      \"Terra Santa\",\r\n" + 
				"      \"Tomé-Açu\",\r\n" + 
				"      \"Tracuateua\",\r\n" + 
				"      \"Trairão\",\r\n" + 
				"      \"Tucumã\",\r\n" + 
				"      \"Tucuruí\",\r\n" + 
				"      \"Ulianópolis\",\r\n" + 
				"      \"Uruará\",\r\n" + 
				"      \"Vigia\",\r\n" + 
				"      \"Viseu\",\r\n" + 
				"      \"Vitória do Xingu\",\r\n" + 
				"      \"Xinguara\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"PB\",\r\n" + 
				"    \"nome\": \"Paraíba\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Água Branca\",\r\n" + 
				"      \"Aguiar\",\r\n" + 
				"      \"Alagoa Grande\",\r\n" + 
				"      \"Alagoa Nova\",\r\n" + 
				"      \"Alagoinha\",\r\n" + 
				"      \"Alcantil\",\r\n" + 
				"      \"Algodão de Jandaíra\",\r\n" + 
				"      \"Alhandra\",\r\n" + 
				"      \"Amparo\",\r\n" + 
				"      \"Aparecida\",\r\n" + 
				"      \"Araçagi\",\r\n" + 
				"      \"Arara\",\r\n" + 
				"      \"Araruna\",\r\n" + 
				"      \"Areia\",\r\n" + 
				"      \"Areia de Baraúnas\",\r\n" + 
				"      \"Areial\",\r\n" + 
				"      \"Aroeiras\",\r\n" + 
				"      \"Assunção\",\r\n" + 
				"      \"Baía da Traição\",\r\n" + 
				"      \"Bananeiras\",\r\n" + 
				"      \"Baraúna\",\r\n" + 
				"      \"Barra de Santa Rosa\",\r\n" + 
				"      \"Barra de Santana\",\r\n" + 
				"      \"Barra de São Miguel\",\r\n" + 
				"      \"Bayeux\",\r\n" + 
				"      \"Belém\",\r\n" + 
				"      \"Belém do Brejo do Cruz\",\r\n" + 
				"      \"Bernardino Batista\",\r\n" + 
				"      \"Boa Ventura\",\r\n" + 
				"      \"Boa Vista\",\r\n" + 
				"      \"Bom Jesus\",\r\n" + 
				"      \"Bom Sucesso\",\r\n" + 
				"      \"Bonito de Santa Fé\",\r\n" + 
				"      \"Boqueirão\",\r\n" + 
				"      \"Borborema\",\r\n" + 
				"      \"Brejo do Cruz\",\r\n" + 
				"      \"Brejo dos Santos\",\r\n" + 
				"      \"Caaporã\",\r\n" + 
				"      \"Cabaceiras\",\r\n" + 
				"      \"Cabedelo\",\r\n" + 
				"      \"Cachoeira dos Índios\",\r\n" + 
				"      \"Cacimba de Areia\",\r\n" + 
				"      \"Cacimba de Dentro\",\r\n" + 
				"      \"Cacimbas\",\r\n" + 
				"      \"Caiçara\",\r\n" + 
				"      \"Cajazeiras\",\r\n" + 
				"      \"Cajazeirinhas\",\r\n" + 
				"      \"Caldas Brandão\",\r\n" + 
				"      \"Camalaú\",\r\n" + 
				"      \"Campina Grande\",\r\n" + 
				"      \"Campo de Santana\",\r\n" + 
				"      \"Capim\",\r\n" + 
				"      \"Caraúbas\",\r\n" + 
				"      \"Carrapateira\",\r\n" + 
				"      \"Casserengue\",\r\n" + 
				"      \"Catingueira\",\r\n" + 
				"      \"Catolé do Rocha\",\r\n" + 
				"      \"Caturité\",\r\n" + 
				"      \"Conceição\",\r\n" + 
				"      \"Condado\",\r\n" + 
				"      \"Conde\",\r\n" + 
				"      \"Congo\",\r\n" + 
				"      \"Coremas\",\r\n" + 
				"      \"Coxixola\",\r\n" + 
				"      \"Cruz do Espírito Santo\",\r\n" + 
				"      \"Cubati\",\r\n" + 
				"      \"Cuité\",\r\n" + 
				"      \"Cuité de Mamanguape\",\r\n" + 
				"      \"Cuitegi\",\r\n" + 
				"      \"Curral de Cima\",\r\n" + 
				"      \"Curral Velho\",\r\n" + 
				"      \"Damião\",\r\n" + 
				"      \"Desterro\",\r\n" + 
				"      \"Diamante\",\r\n" + 
				"      \"Dona Inês\",\r\n" + 
				"      \"Duas Estradas\",\r\n" + 
				"      \"Emas\",\r\n" + 
				"      \"Esperança\",\r\n" + 
				"      \"Fagundes\",\r\n" + 
				"      \"Frei Martinho\",\r\n" + 
				"      \"Gado Bravo\",\r\n" + 
				"      \"Guarabira\",\r\n" + 
				"      \"Gurinhém\",\r\n" + 
				"      \"Gurjão\",\r\n" + 
				"      \"Ibiara\",\r\n" + 
				"      \"Igaracy\",\r\n" + 
				"      \"Imaculada\",\r\n" + 
				"      \"Ingá\",\r\n" + 
				"      \"Itabaiana\",\r\n" + 
				"      \"Itaporanga\",\r\n" + 
				"      \"Itapororoca\",\r\n" + 
				"      \"Itatuba\",\r\n" + 
				"      \"Jacaraú\",\r\n" + 
				"      \"Jericó\",\r\n" + 
				"      \"João Pessoa\",\r\n" + 
				"      \"Juarez Távora\",\r\n" + 
				"      \"Juazeirinho\",\r\n" + 
				"      \"Junco do Seridó\",\r\n" + 
				"      \"Juripiranga\",\r\n" + 
				"      \"Juru\",\r\n" + 
				"      \"Lagoa\",\r\n" + 
				"      \"Lagoa de Dentro\",\r\n" + 
				"      \"Lagoa Seca\",\r\n" + 
				"      \"Lastro\",\r\n" + 
				"      \"Livramento\",\r\n" + 
				"      \"Logradouro\",\r\n" + 
				"      \"Lucena\",\r\n" + 
				"      \"Mãe d'Água\",\r\n" + 
				"      \"Malta\",\r\n" + 
				"      \"Mamanguape\",\r\n" + 
				"      \"Manaíra\",\r\n" + 
				"      \"Marcação\",\r\n" + 
				"      \"Mari\",\r\n" + 
				"      \"Marizópolis\",\r\n" + 
				"      \"Massaranduba\",\r\n" + 
				"      \"Mataraca\",\r\n" + 
				"      \"Matinhas\",\r\n" + 
				"      \"Mato Grosso\",\r\n" + 
				"      \"Maturéia\",\r\n" + 
				"      \"Mogeiro\",\r\n" + 
				"      \"Montadas\",\r\n" + 
				"      \"Monte Horebe\",\r\n" + 
				"      \"Monteiro\",\r\n" + 
				"      \"Mulungu\",\r\n" + 
				"      \"Natuba\",\r\n" + 
				"      \"Nazarezinho\",\r\n" + 
				"      \"Nova Floresta\",\r\n" + 
				"      \"Nova Olinda\",\r\n" + 
				"      \"Nova Palmeira\",\r\n" + 
				"      \"Olho d'Água\",\r\n" + 
				"      \"Olivedos\",\r\n" + 
				"      \"Ouro Velho\",\r\n" + 
				"      \"Parari\",\r\n" + 
				"      \"Passagem\",\r\n" + 
				"      \"Patos\",\r\n" + 
				"      \"Paulista\",\r\n" + 
				"      \"Pedra Branca\",\r\n" + 
				"      \"Pedra Lavrada\",\r\n" + 
				"      \"Pedras de Fogo\",\r\n" + 
				"      \"Pedro Régis\",\r\n" + 
				"      \"Piancó\",\r\n" + 
				"      \"Picuí\",\r\n" + 
				"      \"Pilar\",\r\n" + 
				"      \"Pilões\",\r\n" + 
				"      \"Pilõezinhos\",\r\n" + 
				"      \"Pirpirituba\",\r\n" + 
				"      \"Pitimbu\",\r\n" + 
				"      \"Pocinhos\",\r\n" + 
				"      \"Poço Dantas\",\r\n" + 
				"      \"Poço de José de Moura\",\r\n" + 
				"      \"Pombal\",\r\n" + 
				"      \"Prata\",\r\n" + 
				"      \"Princesa Isabel\",\r\n" + 
				"      \"Puxinanã\",\r\n" + 
				"      \"Queimadas\",\r\n" + 
				"      \"Quixabá\",\r\n" + 
				"      \"Remígio\",\r\n" + 
				"      \"Riachão\",\r\n" + 
				"      \"Riachão do Bacamarte\",\r\n" + 
				"      \"Riachão do Poço\",\r\n" + 
				"      \"Riacho de Santo Antônio\",\r\n" + 
				"      \"Riacho dos Cavalos\",\r\n" + 
				"      \"Rio Tinto\",\r\n" + 
				"      \"Salgadinho\",\r\n" + 
				"      \"Salgado de São Félix\",\r\n" + 
				"      \"Santa Cecília\",\r\n" + 
				"      \"Santa Cruz\",\r\n" + 
				"      \"Santa Helena\",\r\n" + 
				"      \"Santa Inês\",\r\n" + 
				"      \"Santa Luzia\",\r\n" + 
				"      \"Santa Rita\",\r\n" + 
				"      \"Santa Teresinha\",\r\n" + 
				"      \"Santana de Mangueira\",\r\n" + 
				"      \"Santana dos Garrotes\",\r\n" + 
				"      \"Santarém\",\r\n" + 
				"      \"Santo André\",\r\n" + 
				"      \"São Bentinho\",\r\n" + 
				"      \"São Bento\",\r\n" + 
				"      \"São Domingos de Pombal\",\r\n" + 
				"      \"São Domingos do Cariri\",\r\n" + 
				"      \"São Francisco\",\r\n" + 
				"      \"São João do Cariri\",\r\n" + 
				"      \"São João do Rio do Peixe\",\r\n" + 
				"      \"São João do Tigre\",\r\n" + 
				"      \"São José da Lagoa Tapada\",\r\n" + 
				"      \"São José de Caiana\",\r\n" + 
				"      \"São José de Espinharas\",\r\n" + 
				"      \"São José de Piranhas\",\r\n" + 
				"      \"São José de Princesa\",\r\n" + 
				"      \"São José do Bonfim\",\r\n" + 
				"      \"São José do Brejo do Cruz\",\r\n" + 
				"      \"São José do Sabugi\",\r\n" + 
				"      \"São José dos Cordeiros\",\r\n" + 
				"      \"São José dos Ramos\",\r\n" + 
				"      \"São Mamede\",\r\n" + 
				"      \"São Miguel de Taipu\",\r\n" + 
				"      \"São Sebastião de Lagoa de Roça\",\r\n" + 
				"      \"São Sebastião do Umbuzeiro\",\r\n" + 
				"      \"Sapé\",\r\n" + 
				"      \"Seridó\",\r\n" + 
				"      \"Serra Branca\",\r\n" + 
				"      \"Serra da Raiz\",\r\n" + 
				"      \"Serra Grande\",\r\n" + 
				"      \"Serra Redonda\",\r\n" + 
				"      \"Serraria\",\r\n" + 
				"      \"Sertãozinho\",\r\n" + 
				"      \"Sobrado\",\r\n" + 
				"      \"Solânea\",\r\n" + 
				"      \"Soledade\",\r\n" + 
				"      \"Sossêgo\",\r\n" + 
				"      \"Sousa\",\r\n" + 
				"      \"Sumé\",\r\n" + 
				"      \"Taperoá\",\r\n" + 
				"      \"Tavares\",\r\n" + 
				"      \"Teixeira\",\r\n" + 
				"      \"Tenório\",\r\n" + 
				"      \"Triunfo\",\r\n" + 
				"      \"Uiraúna\",\r\n" + 
				"      \"Umbuzeiro\",\r\n" + 
				"      \"Várzea\",\r\n" + 
				"      \"Vieirópolis\",\r\n" + 
				"      \"Vista Serrana\",\r\n" + 
				"      \"Zabelê\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"PE\",\r\n" + 
				"    \"nome\": \"Pernambuco\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Abreu e Lima\",\r\n" + 
				"      \"Afogados da Ingazeira\",\r\n" + 
				"      \"Afrânio\",\r\n" + 
				"      \"Agrestina\",\r\n" + 
				"      \"Água Preta\",\r\n" + 
				"      \"Águas Belas\",\r\n" + 
				"      \"Alagoinha\",\r\n" + 
				"      \"Aliança\",\r\n" + 
				"      \"Altinho\",\r\n" + 
				"      \"Amaraji\",\r\n" + 
				"      \"Angelim\",\r\n" + 
				"      \"Araçoiaba\",\r\n" + 
				"      \"Araripina\",\r\n" + 
				"      \"Arcoverde\",\r\n" + 
				"      \"Barra de Guabiraba\",\r\n" + 
				"      \"Barreiros\",\r\n" + 
				"      \"Belém de Maria\",\r\n" + 
				"      \"Belém de São Francisco\",\r\n" + 
				"      \"Belo Jardim\",\r\n" + 
				"      \"Betânia\",\r\n" + 
				"      \"Bezerros\",\r\n" + 
				"      \"Bodocó\",\r\n" + 
				"      \"Bom Conselho\",\r\n" + 
				"      \"Bom Jardim\",\r\n" + 
				"      \"Bonito\",\r\n" + 
				"      \"Brejão\",\r\n" + 
				"      \"Brejinho\",\r\n" + 
				"      \"Brejo da Madre de Deus\",\r\n" + 
				"      \"Buenos Aires\",\r\n" + 
				"      \"Buíque\",\r\n" + 
				"      \"Cabo de Santo Agostinho\",\r\n" + 
				"      \"Cabrobó\",\r\n" + 
				"      \"Cachoeirinha\",\r\n" + 
				"      \"Caetés\",\r\n" + 
				"      \"Calçado\",\r\n" + 
				"      \"Calumbi\",\r\n" + 
				"      \"Camaragibe\",\r\n" + 
				"      \"Camocim de São Félix\",\r\n" + 
				"      \"Camutanga\",\r\n" + 
				"      \"Canhotinho\",\r\n" + 
				"      \"Capoeiras\",\r\n" + 
				"      \"Carnaíba\",\r\n" + 
				"      \"Carnaubeira da Penha\",\r\n" + 
				"      \"Carpina\",\r\n" + 
				"      \"Caruaru\",\r\n" + 
				"      \"Casinhas\",\r\n" + 
				"      \"Catende\",\r\n" + 
				"      \"Cedro\",\r\n" + 
				"      \"Chã de Alegria\",\r\n" + 
				"      \"Chã Grande\",\r\n" + 
				"      \"Condado\",\r\n" + 
				"      \"Correntes\",\r\n" + 
				"      \"Cortês\",\r\n" + 
				"      \"Cumaru\",\r\n" + 
				"      \"Cupira\",\r\n" + 
				"      \"Custódia\",\r\n" + 
				"      \"Dormentes\",\r\n" + 
				"      \"Escada\",\r\n" + 
				"      \"Exu\",\r\n" + 
				"      \"Feira Nova\",\r\n" + 
				"      \"Fernando de Noronha\",\r\n" + 
				"      \"Ferreiros\",\r\n" + 
				"      \"Flores\",\r\n" + 
				"      \"Floresta\",\r\n" + 
				"      \"Frei Miguelinho\",\r\n" + 
				"      \"Gameleira\",\r\n" + 
				"      \"Garanhuns\",\r\n" + 
				"      \"Glória do Goitá\",\r\n" + 
				"      \"Goiana\",\r\n" + 
				"      \"Granito\",\r\n" + 
				"      \"Gravatá\",\r\n" + 
				"      \"Iati\",\r\n" + 
				"      \"Ibimirim\",\r\n" + 
				"      \"Ibirajuba\",\r\n" + 
				"      \"Igarassu\",\r\n" + 
				"      \"Iguaraci\",\r\n" + 
				"      \"Inajá\",\r\n" + 
				"      \"Ingazeira\",\r\n" + 
				"      \"Ipojuca\",\r\n" + 
				"      \"Ipubi\",\r\n" + 
				"      \"Itacuruba\",\r\n" + 
				"      \"Itaíba\",\r\n" + 
				"      \"Itamaracá\",\r\n" + 
				"      \"Itambé\",\r\n" + 
				"      \"Itapetim\",\r\n" + 
				"      \"Itapissuma\",\r\n" + 
				"      \"Itaquitinga\",\r\n" + 
				"      \"Jaboatão dos Guararapes\",\r\n" + 
				"      \"Jaqueira\",\r\n" + 
				"      \"Jataúba\",\r\n" + 
				"      \"Jatobá\",\r\n" + 
				"      \"João Alfredo\",\r\n" + 
				"      \"Joaquim Nabuco\",\r\n" + 
				"      \"Jucati\",\r\n" + 
				"      \"Jupi\",\r\n" + 
				"      \"Jurema\",\r\n" + 
				"      \"Lagoa do Carro\",\r\n" + 
				"      \"Lagoa do Itaenga\",\r\n" + 
				"      \"Lagoa do Ouro\",\r\n" + 
				"      \"Lagoa dos Gatos\",\r\n" + 
				"      \"Lagoa Grande\",\r\n" + 
				"      \"Lajedo\",\r\n" + 
				"      \"Limoeiro\",\r\n" + 
				"      \"Macaparana\",\r\n" + 
				"      \"Machados\",\r\n" + 
				"      \"Manari\",\r\n" + 
				"      \"Maraial\",\r\n" + 
				"      \"Mirandiba\",\r\n" + 
				"      \"Moreilândia\",\r\n" + 
				"      \"Moreno\",\r\n" + 
				"      \"Nazaré da Mata\",\r\n" + 
				"      \"Olinda\",\r\n" + 
				"      \"Orobó\",\r\n" + 
				"      \"Orocó\",\r\n" + 
				"      \"Ouricuri\",\r\n" + 
				"      \"Palmares\",\r\n" + 
				"      \"Palmeirina\",\r\n" + 
				"      \"Panelas\",\r\n" + 
				"      \"Paranatama\",\r\n" + 
				"      \"Parnamirim\",\r\n" + 
				"      \"Passira\",\r\n" + 
				"      \"Paudalho\",\r\n" + 
				"      \"Paulista\",\r\n" + 
				"      \"Pedra\",\r\n" + 
				"      \"Pesqueira\",\r\n" + 
				"      \"Petrolândia\",\r\n" + 
				"      \"Petrolina\",\r\n" + 
				"      \"Poção\",\r\n" + 
				"      \"Pombos\",\r\n" + 
				"      \"Primavera\",\r\n" + 
				"      \"Quipapá\",\r\n" + 
				"      \"Quixaba\",\r\n" + 
				"      \"Recife\",\r\n" + 
				"      \"Riacho das Almas\",\r\n" + 
				"      \"Ribeirão\",\r\n" + 
				"      \"Rio Formoso\",\r\n" + 
				"      \"Sairé\",\r\n" + 
				"      \"Salgadinho\",\r\n" + 
				"      \"Salgueiro\",\r\n" + 
				"      \"Saloá\",\r\n" + 
				"      \"Sanharó\",\r\n" + 
				"      \"Santa Cruz\",\r\n" + 
				"      \"Santa Cruz da Baixa Verde\",\r\n" + 
				"      \"Santa Cruz do Capibaribe\",\r\n" + 
				"      \"Santa Filomena\",\r\n" + 
				"      \"Santa Maria da Boa Vista\",\r\n" + 
				"      \"Santa Maria do Cambucá\",\r\n" + 
				"      \"Santa Terezinha\",\r\n" + 
				"      \"São Benedito do Sul\",\r\n" + 
				"      \"São Bento do Una\",\r\n" + 
				"      \"São Caitano\",\r\n" + 
				"      \"São João\",\r\n" + 
				"      \"São Joaquim do Monte\",\r\n" + 
				"      \"São José da Coroa Grande\",\r\n" + 
				"      \"São José do Belmonte\",\r\n" + 
				"      \"São José do Egito\",\r\n" + 
				"      \"São Lourenço da Mata\",\r\n" + 
				"      \"São Vicente Ferrer\",\r\n" + 
				"      \"Serra Talhada\",\r\n" + 
				"      \"Serrita\",\r\n" + 
				"      \"Sertânia\",\r\n" + 
				"      \"Sirinhaém\",\r\n" + 
				"      \"Solidão\",\r\n" + 
				"      \"Surubim\",\r\n" + 
				"      \"Tabira\",\r\n" + 
				"      \"Tacaimbó\",\r\n" + 
				"      \"Tacaratu\",\r\n" + 
				"      \"Tamandaré\",\r\n" + 
				"      \"Taquaritinga do Norte\",\r\n" + 
				"      \"Terezinha\",\r\n" + 
				"      \"Terra Nova\",\r\n" + 
				"      \"Timbaúba\",\r\n" + 
				"      \"Toritama\",\r\n" + 
				"      \"Tracunhaém\",\r\n" + 
				"      \"Trindade\",\r\n" + 
				"      \"Triunfo\",\r\n" + 
				"      \"Tupanatinga\",\r\n" + 
				"      \"Tuparetama\",\r\n" + 
				"      \"Venturosa\",\r\n" + 
				"      \"Verdejante\",\r\n" + 
				"      \"Vertente do Lério\",\r\n" + 
				"      \"Vertentes\",\r\n" + 
				"      \"Vicência\",\r\n" + 
				"      \"Vitória de Santo Antão\",\r\n" + 
				"      \"Xexéu\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"PI\",\r\n" + 
				"    \"nome\": \"Piauí\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Acauã\",\r\n" + 
				"      \"Agricolândia\",\r\n" + 
				"      \"Água Branca\",\r\n" + 
				"      \"Alagoinha do Piauí\",\r\n" + 
				"      \"Alegrete do Piauí\",\r\n" + 
				"      \"Alto Longá\",\r\n" + 
				"      \"Altos\",\r\n" + 
				"      \"Alvorada do Gurguéia\",\r\n" + 
				"      \"Amarante\",\r\n" + 
				"      \"Angical do Piauí\",\r\n" + 
				"      \"Anísio de Abreu\",\r\n" + 
				"      \"Antônio Almeida\",\r\n" + 
				"      \"Aroazes\",\r\n" + 
				"      \"Arraial\",\r\n" + 
				"      \"Assunção do Piauí\",\r\n" + 
				"      \"Avelino Lopes\",\r\n" + 
				"      \"Baixa Grande do Ribeiro\",\r\n" + 
				"      \"Barra d'Alcântara\",\r\n" + 
				"      \"Barras\",\r\n" + 
				"      \"Barreiras do Piauí\",\r\n" + 
				"      \"Barro Duro\",\r\n" + 
				"      \"Batalha\",\r\n" + 
				"      \"Bela Vista do Piauí\",\r\n" + 
				"      \"Belém do Piauí\",\r\n" + 
				"      \"Beneditinos\",\r\n" + 
				"      \"Bertolínia\",\r\n" + 
				"      \"Betânia do Piauí\",\r\n" + 
				"      \"Boa Hora\",\r\n" + 
				"      \"Bocaina\",\r\n" + 
				"      \"Bom Jesus\",\r\n" + 
				"      \"Bom Princípio do Piauí\",\r\n" + 
				"      \"Bonfim do Piauí\",\r\n" + 
				"      \"Boqueirão do Piauí\",\r\n" + 
				"      \"Brasileira\",\r\n" + 
				"      \"Brejo do Piauí\",\r\n" + 
				"      \"Buriti dos Lopes\",\r\n" + 
				"      \"Buriti dos Montes\",\r\n" + 
				"      \"Cabeceiras do Piauí\",\r\n" + 
				"      \"Cajazeiras do Piauí\",\r\n" + 
				"      \"Cajueiro da Praia\",\r\n" + 
				"      \"Caldeirão Grande do Piauí\",\r\n" + 
				"      \"Campinas do Piauí\",\r\n" + 
				"      \"Campo Alegre do Fidalgo\",\r\n" + 
				"      \"Campo Grande do Piauí\",\r\n" + 
				"      \"Campo Largo do Piauí\",\r\n" + 
				"      \"Campo Maior\",\r\n" + 
				"      \"Canavieira\",\r\n" + 
				"      \"Canto do Buriti\",\r\n" + 
				"      \"Capitão de Campos\",\r\n" + 
				"      \"Capitão Gervásio Oliveira\",\r\n" + 
				"      \"Caracol\",\r\n" + 
				"      \"Caraúbas do Piauí\",\r\n" + 
				"      \"Caridade do Piauí\",\r\n" + 
				"      \"Castelo do Piauí\",\r\n" + 
				"      \"Caxingó\",\r\n" + 
				"      \"Cocal\",\r\n" + 
				"      \"Cocal de Telha\",\r\n" + 
				"      \"Cocal dos Alves\",\r\n" + 
				"      \"Coivaras\",\r\n" + 
				"      \"Colônia do Gurguéia\",\r\n" + 
				"      \"Colônia do Piauí\",\r\n" + 
				"      \"Conceição do Canindé\",\r\n" + 
				"      \"Coronel José Dias\",\r\n" + 
				"      \"Corrente\",\r\n" + 
				"      \"Cristalândia do Piauí\",\r\n" + 
				"      \"Cristino Castro\",\r\n" + 
				"      \"Curimatá\",\r\n" + 
				"      \"Currais\",\r\n" + 
				"      \"Curral Novo do Piauí\",\r\n" + 
				"      \"Curralinhos\",\r\n" + 
				"      \"Demerval Lobão\",\r\n" + 
				"      \"Dirceu Arcoverde\",\r\n" + 
				"      \"Dom Expedito Lopes\",\r\n" + 
				"      \"Dom Inocêncio\",\r\n" + 
				"      \"Domingos Mourão\",\r\n" + 
				"      \"Elesbão Veloso\",\r\n" + 
				"      \"Eliseu Martins\",\r\n" + 
				"      \"Esperantina\",\r\n" + 
				"      \"Fartura do Piauí\",\r\n" + 
				"      \"Flores do Piauí\",\r\n" + 
				"      \"Floresta do Piauí\",\r\n" + 
				"      \"Floriano\",\r\n" + 
				"      \"Francinópolis\",\r\n" + 
				"      \"Francisco Ayres\",\r\n" + 
				"      \"Francisco Macedo\",\r\n" + 
				"      \"Francisco Santos\",\r\n" + 
				"      \"Fronteiras\",\r\n" + 
				"      \"Geminiano\",\r\n" + 
				"      \"Gilbués\",\r\n" + 
				"      \"Guadalupe\",\r\n" + 
				"      \"Guaribas\",\r\n" + 
				"      \"Hugo Napoleão\",\r\n" + 
				"      \"Ilha Grande\",\r\n" + 
				"      \"Inhuma\",\r\n" + 
				"      \"Ipiranga do Piauí\",\r\n" + 
				"      \"Isaías Coelho\",\r\n" + 
				"      \"Itainópolis\",\r\n" + 
				"      \"Itaueira\",\r\n" + 
				"      \"Jacobina do Piauí\",\r\n" + 
				"      \"Jaicós\",\r\n" + 
				"      \"Jardim do Mulato\",\r\n" + 
				"      \"Jatobá do Piauí\",\r\n" + 
				"      \"Jerumenha\",\r\n" + 
				"      \"João Costa\",\r\n" + 
				"      \"Joaquim Pires\",\r\n" + 
				"      \"Joca Marques\",\r\n" + 
				"      \"José de Freitas\",\r\n" + 
				"      \"Juazeiro do Piauí\",\r\n" + 
				"      \"Júlio Borges\",\r\n" + 
				"      \"Jurema\",\r\n" + 
				"      \"Lagoa Alegre\",\r\n" + 
				"      \"Lagoa de São Francisco\",\r\n" + 
				"      \"Lagoa do Barro do Piauí\",\r\n" + 
				"      \"Lagoa do Piauí\",\r\n" + 
				"      \"Lagoa do Sítio\",\r\n" + 
				"      \"Lagoinha do Piauí\",\r\n" + 
				"      \"Landri Sales\",\r\n" + 
				"      \"Luís Correia\",\r\n" + 
				"      \"Luzilândia\",\r\n" + 
				"      \"Madeiro\",\r\n" + 
				"      \"Manoel Emídio\",\r\n" + 
				"      \"Marcolândia\",\r\n" + 
				"      \"Marcos Parente\",\r\n" + 
				"      \"Massapê do Piauí\",\r\n" + 
				"      \"Matias Olímpio\",\r\n" + 
				"      \"Miguel Alves\",\r\n" + 
				"      \"Miguel Leão\",\r\n" + 
				"      \"Milton Brandão\",\r\n" + 
				"      \"Monsenhor Gil\",\r\n" + 
				"      \"Monsenhor Hipólito\",\r\n" + 
				"      \"Monte Alegre do Piauí\",\r\n" + 
				"      \"Morro Cabeça no Tempo\",\r\n" + 
				"      \"Morro do Chapéu do Piauí\",\r\n" + 
				"      \"Murici dos Portelas\",\r\n" + 
				"      \"Nazaré do Piauí\",\r\n" + 
				"      \"Nossa Senhora de Nazaré\",\r\n" + 
				"      \"Nossa Senhora dos Remédios\",\r\n" + 
				"      \"Nova Santa Rita\",\r\n" + 
				"      \"Novo Oriente do Piauí\",\r\n" + 
				"      \"Novo Santo Antônio\",\r\n" + 
				"      \"Oeiras\",\r\n" + 
				"      \"Olho d'Água do Piauí\",\r\n" + 
				"      \"Padre Marcos\",\r\n" + 
				"      \"Paes Landim\",\r\n" + 
				"      \"Pajeú do Piauí\",\r\n" + 
				"      \"Palmeira do Piauí\",\r\n" + 
				"      \"Palmeirais\",\r\n" + 
				"      \"Paquetá\",\r\n" + 
				"      \"Parnaguá\",\r\n" + 
				"      \"Parnaíba\",\r\n" + 
				"      \"Passagem Franca do Piauí\",\r\n" + 
				"      \"Patos do Piauí\",\r\n" + 
				"      \"Pau d'Arco do Piauí\",\r\n" + 
				"      \"Paulistana\",\r\n" + 
				"      \"Pavussu\",\r\n" + 
				"      \"Pedro II\",\r\n" + 
				"      \"Pedro Laurentino\",\r\n" + 
				"      \"Picos\",\r\n" + 
				"      \"Pimenteiras\",\r\n" + 
				"      \"Pio IX\",\r\n" + 
				"      \"Piracuruca\",\r\n" + 
				"      \"Piripiri\",\r\n" + 
				"      \"Porto\",\r\n" + 
				"      \"Porto Alegre do Piauí\",\r\n" + 
				"      \"Prata do Piauí\",\r\n" + 
				"      \"Queimada Nova\",\r\n" + 
				"      \"Redenção do Gurguéia\",\r\n" + 
				"      \"Regeneração\",\r\n" + 
				"      \"Riacho Frio\",\r\n" + 
				"      \"Ribeira do Piauí\",\r\n" + 
				"      \"Ribeiro Gonçalves\",\r\n" + 
				"      \"Rio Grande do Piauí\",\r\n" + 
				"      \"Santa Cruz do Piauí\",\r\n" + 
				"      \"Santa Cruz dos Milagres\",\r\n" + 
				"      \"Santa Filomena\",\r\n" + 
				"      \"Santa Luz\",\r\n" + 
				"      \"Santa Rosa do Piauí\",\r\n" + 
				"      \"Santana do Piauí\",\r\n" + 
				"      \"Santo Antônio de Lisboa\",\r\n" + 
				"      \"Santo Antônio dos Milagres\",\r\n" + 
				"      \"Santo Inácio do Piauí\",\r\n" + 
				"      \"São Braz do Piauí\",\r\n" + 
				"      \"São Félix do Piauí\",\r\n" + 
				"      \"São Francisco de Assis do Piauí\",\r\n" + 
				"      \"São Francisco do Piauí\",\r\n" + 
				"      \"São Gonçalo do Gurguéia\",\r\n" + 
				"      \"São Gonçalo do Piauí\",\r\n" + 
				"      \"São João da Canabrava\",\r\n" + 
				"      \"São João da Fronteira\",\r\n" + 
				"      \"São João da Serra\",\r\n" + 
				"      \"São João da Varjota\",\r\n" + 
				"      \"São João do Arraial\",\r\n" + 
				"      \"São João do Piauí\",\r\n" + 
				"      \"São José do Divino\",\r\n" + 
				"      \"São José do Peixe\",\r\n" + 
				"      \"São José do Piauí\",\r\n" + 
				"      \"São Julião\",\r\n" + 
				"      \"São Lourenço do Piauí\",\r\n" + 
				"      \"São Luis do Piauí\",\r\n" + 
				"      \"São Miguel da Baixa Grande\",\r\n" + 
				"      \"São Miguel do Fidalgo\",\r\n" + 
				"      \"São Miguel do Tapuio\",\r\n" + 
				"      \"São Pedro do Piauí\",\r\n" + 
				"      \"São Raimundo Nonato\",\r\n" + 
				"      \"Sebastião Barros\",\r\n" + 
				"      \"Sebastião Leal\",\r\n" + 
				"      \"Sigefredo Pacheco\",\r\n" + 
				"      \"Simões\",\r\n" + 
				"      \"Simplício Mendes\",\r\n" + 
				"      \"Socorro do Piauí\",\r\n" + 
				"      \"Sussuapara\",\r\n" + 
				"      \"Tamboril do Piauí\",\r\n" + 
				"      \"Tanque do Piauí\",\r\n" + 
				"      \"Teresina\",\r\n" + 
				"      \"União\",\r\n" + 
				"      \"Uruçuí\",\r\n" + 
				"      \"Valença do Piauí\",\r\n" + 
				"      \"Várzea Branca\",\r\n" + 
				"      \"Várzea Grande\",\r\n" + 
				"      \"Vera Mendes\",\r\n" + 
				"      \"Vila Nova do Piauí\",\r\n" + 
				"      \"Wall Ferraz\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"PR\",\r\n" + 
				"    \"nome\": \"Paraná\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Abatiá\",\r\n" + 
				"      \"Adrianópolis\",\r\n" + 
				"      \"Agudos do Sul\",\r\n" + 
				"      \"Almirante Tamandaré\",\r\n" + 
				"      \"Altamira do Paraná\",\r\n" + 
				"      \"Alto Paraná\",\r\n" + 
				"      \"Alto Piquiri\",\r\n" + 
				"      \"Altônia\",\r\n" + 
				"      \"Alvorada do Sul\",\r\n" + 
				"      \"Amaporã\",\r\n" + 
				"      \"Ampére\",\r\n" + 
				"      \"Anahy\",\r\n" + 
				"      \"Andirá\",\r\n" + 
				"      \"Ângulo\",\r\n" + 
				"      \"Antonina\",\r\n" + 
				"      \"Antônio Olinto\",\r\n" + 
				"      \"Apucarana\",\r\n" + 
				"      \"Arapongas\",\r\n" + 
				"      \"Arapoti\",\r\n" + 
				"      \"Arapuã\",\r\n" + 
				"      \"Araruna\",\r\n" + 
				"      \"Araucária\",\r\n" + 
				"      \"Ariranha do Ivaí\",\r\n" + 
				"      \"Assaí\",\r\n" + 
				"      \"Assis Chateaubriand\",\r\n" + 
				"      \"Astorga\",\r\n" + 
				"      \"Atalaia\",\r\n" + 
				"      \"Balsa Nova\",\r\n" + 
				"      \"Bandeirantes\",\r\n" + 
				"      \"Barbosa Ferraz\",\r\n" + 
				"      \"Barra do Jacaré\",\r\n" + 
				"      \"Barracão\",\r\n" + 
				"      \"Bela Vista da Caroba\",\r\n" + 
				"      \"Bela Vista do Paraíso\",\r\n" + 
				"      \"Bituruna\",\r\n" + 
				"      \"Boa Esperança\",\r\n" + 
				"      \"Boa Esperança do Iguaçu\",\r\n" + 
				"      \"Boa Ventura de São Roque\",\r\n" + 
				"      \"Boa Vista da Aparecida\",\r\n" + 
				"      \"Bocaiúva do Sul\",\r\n" + 
				"      \"Bom Jesus do Sul\",\r\n" + 
				"      \"Bom Sucesso\",\r\n" + 
				"      \"Bom Sucesso do Sul\",\r\n" + 
				"      \"Borrazópolis\",\r\n" + 
				"      \"Braganey\",\r\n" + 
				"      \"Brasilândia do Sul\",\r\n" + 
				"      \"Cafeara\",\r\n" + 
				"      \"Cafelândia\",\r\n" + 
				"      \"Cafezal do Sul\",\r\n" + 
				"      \"Califórnia\",\r\n" + 
				"      \"Cambará\",\r\n" + 
				"      \"Cambé\",\r\n" + 
				"      \"Cambira\",\r\n" + 
				"      \"Campina da Lagoa\",\r\n" + 
				"      \"Campina do Simão\",\r\n" + 
				"      \"Campina Grande do Sul\",\r\n" + 
				"      \"Campo Bonito\",\r\n" + 
				"      \"Campo do Tenente\",\r\n" + 
				"      \"Campo Largo\",\r\n" + 
				"      \"Campo Magro\",\r\n" + 
				"      \"Campo Mourão\",\r\n" + 
				"      \"Cândido de Abreu\",\r\n" + 
				"      \"Candói\",\r\n" + 
				"      \"Cantagalo\",\r\n" + 
				"      \"Capanema\",\r\n" + 
				"      \"Capitão Leônidas Marques\",\r\n" + 
				"      \"Carambeí\",\r\n" + 
				"      \"Carlópolis\",\r\n" + 
				"      \"Cascavel\",\r\n" + 
				"      \"Castro\",\r\n" + 
				"      \"Catanduvas\",\r\n" + 
				"      \"Centenário do Sul\",\r\n" + 
				"      \"Cerro Azul\",\r\n" + 
				"      \"Céu Azul\",\r\n" + 
				"      \"Chopinzinho\",\r\n" + 
				"      \"Cianorte\",\r\n" + 
				"      \"Cidade Gaúcha\",\r\n" + 
				"      \"Clevelândia\",\r\n" + 
				"      \"Colombo\",\r\n" + 
				"      \"Colorado\",\r\n" + 
				"      \"Congonhinhas\",\r\n" + 
				"      \"Conselheiro Mairinck\",\r\n" + 
				"      \"Contenda\",\r\n" + 
				"      \"Corbélia\",\r\n" + 
				"      \"Cornélio Procópio\",\r\n" + 
				"      \"Coronel Domingos Soares\",\r\n" + 
				"      \"Coronel Vivida\",\r\n" + 
				"      \"Corumbataí do Sul\",\r\n" + 
				"      \"Cruz Machado\",\r\n" + 
				"      \"Cruzeiro do Iguaçu\",\r\n" + 
				"      \"Cruzeiro do Oeste\",\r\n" + 
				"      \"Cruzeiro do Sul\",\r\n" + 
				"      \"Cruzmaltina\",\r\n" + 
				"      \"Curitiba\",\r\n" + 
				"      \"Curiúva\",\r\n" + 
				"      \"Diamante d'Oeste\",\r\n" + 
				"      \"Diamante do Norte\",\r\n" + 
				"      \"Diamante do Sul\",\r\n" + 
				"      \"Dois Vizinhos\",\r\n" + 
				"      \"Douradina\",\r\n" + 
				"      \"Doutor Camargo\",\r\n" + 
				"      \"Doutor Ulysses\",\r\n" + 
				"      \"Enéas Marques\",\r\n" + 
				"      \"Engenheiro Beltrão\",\r\n" + 
				"      \"Entre Rios do Oeste\",\r\n" + 
				"      \"Esperança Nova\",\r\n" + 
				"      \"Espigão Alto do Iguaçu\",\r\n" + 
				"      \"Farol\",\r\n" + 
				"      \"Faxinal\",\r\n" + 
				"      \"Fazenda Rio Grande\",\r\n" + 
				"      \"Fênix\",\r\n" + 
				"      \"Fernandes Pinheiro\",\r\n" + 
				"      \"Figueira\",\r\n" + 
				"      \"Flor da Serra do Sul\",\r\n" + 
				"      \"Floraí\",\r\n" + 
				"      \"Floresta\",\r\n" + 
				"      \"Florestópolis\",\r\n" + 
				"      \"Flórida\",\r\n" + 
				"      \"Formosa do Oeste\",\r\n" + 
				"      \"Foz do Iguaçu\",\r\n" + 
				"      \"Foz do Jordão\",\r\n" + 
				"      \"Francisco Alves\",\r\n" + 
				"      \"Francisco Beltrão\",\r\n" + 
				"      \"General Carneiro\",\r\n" + 
				"      \"Godoy Moreira\",\r\n" + 
				"      \"Goioerê\",\r\n" + 
				"      \"Goioxim\",\r\n" + 
				"      \"Grandes Rios\",\r\n" + 
				"      \"Guaíra\",\r\n" + 
				"      \"Guairaçá\",\r\n" + 
				"      \"Guamiranga\",\r\n" + 
				"      \"Guapirama\",\r\n" + 
				"      \"Guaporema\",\r\n" + 
				"      \"Guaraci\",\r\n" + 
				"      \"Guaraniaçu\",\r\n" + 
				"      \"Guarapuava\",\r\n" + 
				"      \"Guaraqueçaba\",\r\n" + 
				"      \"Guaratuba\",\r\n" + 
				"      \"Honório Serpa\",\r\n" + 
				"      \"Ibaiti\",\r\n" + 
				"      \"Ibema\",\r\n" + 
				"      \"Ibiporã\",\r\n" + 
				"      \"Icaraíma\",\r\n" + 
				"      \"Iguaraçu\",\r\n" + 
				"      \"Iguatu\",\r\n" + 
				"      \"Imbaú\",\r\n" + 
				"      \"Imbituva\",\r\n" + 
				"      \"Inácio Martins\",\r\n" + 
				"      \"Inajá\",\r\n" + 
				"      \"Indianópolis\",\r\n" + 
				"      \"Ipiranga\",\r\n" + 
				"      \"Iporã\",\r\n" + 
				"      \"Iracema do Oeste\",\r\n" + 
				"      \"Irati\",\r\n" + 
				"      \"Iretama\",\r\n" + 
				"      \"Itaguajé\",\r\n" + 
				"      \"Itaipulândia\",\r\n" + 
				"      \"Itambaracá\",\r\n" + 
				"      \"Itambé\",\r\n" + 
				"      \"Itapejara d'Oeste\",\r\n" + 
				"      \"Itaperuçu\",\r\n" + 
				"      \"Itaúna do Sul\",\r\n" + 
				"      \"Ivaí\",\r\n" + 
				"      \"Ivaiporã\",\r\n" + 
				"      \"Ivaté\",\r\n" + 
				"      \"Ivatuba\",\r\n" + 
				"      \"Jaboti\",\r\n" + 
				"      \"Jacarezinho\",\r\n" + 
				"      \"Jaguapitã\",\r\n" + 
				"      \"Jaguariaíva\",\r\n" + 
				"      \"Jandaia do Sul\",\r\n" + 
				"      \"Janiópolis\",\r\n" + 
				"      \"Japira\",\r\n" + 
				"      \"Japurá\",\r\n" + 
				"      \"Jardim Alegre\",\r\n" + 
				"      \"Jardim Olinda\",\r\n" + 
				"      \"Jataizinho\",\r\n" + 
				"      \"Jesuítas\",\r\n" + 
				"      \"Joaquim Távora\",\r\n" + 
				"      \"Jundiaí do Sul\",\r\n" + 
				"      \"Juranda\",\r\n" + 
				"      \"Jussara\",\r\n" + 
				"      \"Kaloré\",\r\n" + 
				"      \"Lapa\",\r\n" + 
				"      \"Laranjal\",\r\n" + 
				"      \"Laranjeiras do Sul\",\r\n" + 
				"      \"Leópolis\",\r\n" + 
				"      \"Lidianópolis\",\r\n" + 
				"      \"Lindoeste\",\r\n" + 
				"      \"Loanda\",\r\n" + 
				"      \"Lobato\",\r\n" + 
				"      \"Londrina\",\r\n" + 
				"      \"Luiziana\",\r\n" + 
				"      \"Lunardelli\",\r\n" + 
				"      \"Lupionópolis\",\r\n" + 
				"      \"Mallet\",\r\n" + 
				"      \"Mamborê\",\r\n" + 
				"      \"Mandaguaçu\",\r\n" + 
				"      \"Mandaguari\",\r\n" + 
				"      \"Mandirituba\",\r\n" + 
				"      \"Manfrinópolis\",\r\n" + 
				"      \"Mangueirinha\",\r\n" + 
				"      \"Manoel Ribas\",\r\n" + 
				"      \"Marechal Cândido Rondon\",\r\n" + 
				"      \"Maria Helena\",\r\n" + 
				"      \"Marialva\",\r\n" + 
				"      \"Marilândia do Sul\",\r\n" + 
				"      \"Marilena\",\r\n" + 
				"      \"Mariluz\",\r\n" + 
				"      \"Maringá\",\r\n" + 
				"      \"Mariópolis\",\r\n" + 
				"      \"Maripá\",\r\n" + 
				"      \"Marmeleiro\",\r\n" + 
				"      \"Marquinho\",\r\n" + 
				"      \"Marumbi\",\r\n" + 
				"      \"Matelândia\",\r\n" + 
				"      \"Matinhos\",\r\n" + 
				"      \"Mato Rico\",\r\n" + 
				"      \"Mauá da Serra\",\r\n" + 
				"      \"Medianeira\",\r\n" + 
				"      \"Mercedes\",\r\n" + 
				"      \"Mirador\",\r\n" + 
				"      \"Miraselva\",\r\n" + 
				"      \"Missal\",\r\n" + 
				"      \"Moreira Sales\",\r\n" + 
				"      \"Morretes\",\r\n" + 
				"      \"Munhoz de Melo\",\r\n" + 
				"      \"Nossa Senhora das Graças\",\r\n" + 
				"      \"Nova Aliança do Ivaí\",\r\n" + 
				"      \"Nova América da Colina\",\r\n" + 
				"      \"Nova Aurora\",\r\n" + 
				"      \"Nova Cantu\",\r\n" + 
				"      \"Nova Esperança\",\r\n" + 
				"      \"Nova Esperança do Sudoeste\",\r\n" + 
				"      \"Nova Fátima\",\r\n" + 
				"      \"Nova Laranjeiras\",\r\n" + 
				"      \"Nova Londrina\",\r\n" + 
				"      \"Nova Olímpia\",\r\n" + 
				"      \"Nova Prata do Iguaçu\",\r\n" + 
				"      \"Nova Santa Bárbara\",\r\n" + 
				"      \"Nova Santa Rosa\",\r\n" + 
				"      \"Nova Tebas\",\r\n" + 
				"      \"Novo Itacolomi\",\r\n" + 
				"      \"Ortigueira\",\r\n" + 
				"      \"Ourizona\",\r\n" + 
				"      \"Ouro Verde do Oeste\",\r\n" + 
				"      \"Paiçandu\",\r\n" + 
				"      \"Palmas\",\r\n" + 
				"      \"Palmeira\",\r\n" + 
				"      \"Palmital\",\r\n" + 
				"      \"Palotina\",\r\n" + 
				"      \"Paraíso do Norte\",\r\n" + 
				"      \"Paranacity\",\r\n" + 
				"      \"Paranaguá\",\r\n" + 
				"      \"Paranapoema\",\r\n" + 
				"      \"Paranavaí\",\r\n" + 
				"      \"Pato Bragado\",\r\n" + 
				"      \"Pato Branco\",\r\n" + 
				"      \"Paula Freitas\",\r\n" + 
				"      \"Paulo Frontin\",\r\n" + 
				"      \"Peabiru\",\r\n" + 
				"      \"Perobal\",\r\n" + 
				"      \"Pérola\",\r\n" + 
				"      \"Pérola d'Oeste\",\r\n" + 
				"      \"Piên\",\r\n" + 
				"      \"Pinhais\",\r\n" + 
				"      \"Pinhal de São Bento\",\r\n" + 
				"      \"Pinhalão\",\r\n" + 
				"      \"Pinhão\",\r\n" + 
				"      \"Piraí do Sul\",\r\n" + 
				"      \"Piraquara\",\r\n" + 
				"      \"Pitanga\",\r\n" + 
				"      \"Pitangueiras\",\r\n" + 
				"      \"Planaltina do Paraná\",\r\n" + 
				"      \"Planalto\",\r\n" + 
				"      \"Ponta Grossa\",\r\n" + 
				"      \"Pontal do Paraná\",\r\n" + 
				"      \"Porecatu\",\r\n" + 
				"      \"Porto Amazonas\",\r\n" + 
				"      \"Porto Barreiro\",\r\n" + 
				"      \"Porto Rico\",\r\n" + 
				"      \"Porto Vitória\",\r\n" + 
				"      \"Prado Ferreira\",\r\n" + 
				"      \"Pranchita\",\r\n" + 
				"      \"Presidente Castelo Branco\",\r\n" + 
				"      \"Primeiro de Maio\",\r\n" + 
				"      \"Prudentópolis\",\r\n" + 
				"      \"Quarto Centenário\",\r\n" + 
				"      \"Quatiguá\",\r\n" + 
				"      \"Quatro Barras\",\r\n" + 
				"      \"Quatro Pontes\",\r\n" + 
				"      \"Quedas do Iguaçu\",\r\n" + 
				"      \"Querência do Norte\",\r\n" + 
				"      \"Quinta do Sol\",\r\n" + 
				"      \"Quitandinha\",\r\n" + 
				"      \"Ramilândia\",\r\n" + 
				"      \"Rancho Alegre\",\r\n" + 
				"      \"Rancho Alegre d'Oeste\",\r\n" + 
				"      \"Realeza\",\r\n" + 
				"      \"Rebouças\",\r\n" + 
				"      \"Renascença\",\r\n" + 
				"      \"Reserva\",\r\n" + 
				"      \"Reserva do Iguaçu\",\r\n" + 
				"      \"Ribeirão Claro\",\r\n" + 
				"      \"Ribeirão do Pinhal\",\r\n" + 
				"      \"Rio Azul\",\r\n" + 
				"      \"Rio Bom\",\r\n" + 
				"      \"Rio Bonito do Iguaçu\",\r\n" + 
				"      \"Rio Branco do Ivaí\",\r\n" + 
				"      \"Rio Branco do Sul\",\r\n" + 
				"      \"Rio Negro\",\r\n" + 
				"      \"Rolândia\",\r\n" + 
				"      \"Roncador\",\r\n" + 
				"      \"Rondon\",\r\n" + 
				"      \"Rosário do Ivaí\",\r\n" + 
				"      \"Sabáudia\",\r\n" + 
				"      \"Salgado Filho\",\r\n" + 
				"      \"Salto do Itararé\",\r\n" + 
				"      \"Salto do Lontra\",\r\n" + 
				"      \"Santa Amélia\",\r\n" + 
				"      \"Santa Cecília do Pavão\",\r\n" + 
				"      \"Santa Cruz Monte Castelo\",\r\n" + 
				"      \"Santa Fé\",\r\n" + 
				"      \"Santa Helena\",\r\n" + 
				"      \"Santa Inês\",\r\n" + 
				"      \"Santa Isabel do Ivaí\",\r\n" + 
				"      \"Santa Izabel do Oeste\",\r\n" + 
				"      \"Santa Lúcia\",\r\n" + 
				"      \"Santa Maria do Oeste\",\r\n" + 
				"      \"Santa Mariana\",\r\n" + 
				"      \"Santa Mônica\",\r\n" + 
				"      \"Santa Tereza do Oeste\",\r\n" + 
				"      \"Santa Terezinha de Itaipu\",\r\n" + 
				"      \"Santana do Itararé\",\r\n" + 
				"      \"Santo Antônio da Platina\",\r\n" + 
				"      \"Santo Antônio do Caiuá\",\r\n" + 
				"      \"Santo Antônio do Paraíso\",\r\n" + 
				"      \"Santo Antônio do Sudoeste\",\r\n" + 
				"      \"Santo Inácio\",\r\n" + 
				"      \"São Carlos do Ivaí\",\r\n" + 
				"      \"São Jerônimo da Serra\",\r\n" + 
				"      \"São João\",\r\n" + 
				"      \"São João do Caiuá\",\r\n" + 
				"      \"São João do Ivaí\",\r\n" + 
				"      \"São João do Triunfo\",\r\n" + 
				"      \"São Jorge d'Oeste\",\r\n" + 
				"      \"São Jorge do Ivaí\",\r\n" + 
				"      \"São Jorge do Patrocínio\",\r\n" + 
				"      \"São José da Boa Vista\",\r\n" + 
				"      \"São José das Palmeiras\",\r\n" + 
				"      \"São José dos Pinhais\",\r\n" + 
				"      \"São Manoel do Paraná\",\r\n" + 
				"      \"São Mateus do Sul\",\r\n" + 
				"      \"São Miguel do Iguaçu\",\r\n" + 
				"      \"São Pedro do Iguaçu\",\r\n" + 
				"      \"São Pedro do Ivaí\",\r\n" + 
				"      \"São Pedro do Paraná\",\r\n" + 
				"      \"São Sebastião da Amoreira\",\r\n" + 
				"      \"São Tomé\",\r\n" + 
				"      \"Sapopema\",\r\n" + 
				"      \"Sarandi\",\r\n" + 
				"      \"Saudade do Iguaçu\",\r\n" + 
				"      \"Sengés\",\r\n" + 
				"      \"Serranópolis do Iguaçu\",\r\n" + 
				"      \"Sertaneja\",\r\n" + 
				"      \"Sertanópolis\",\r\n" + 
				"      \"Siqueira Campos\",\r\n" + 
				"      \"Sulina\",\r\n" + 
				"      \"Tamarana\",\r\n" + 
				"      \"Tamboara\",\r\n" + 
				"      \"Tapejara\",\r\n" + 
				"      \"Tapira\",\r\n" + 
				"      \"Teixeira Soares\",\r\n" + 
				"      \"Telêmaco Borba\",\r\n" + 
				"      \"Terra Boa\",\r\n" + 
				"      \"Terra Rica\",\r\n" + 
				"      \"Terra Roxa\",\r\n" + 
				"      \"Tibagi\",\r\n" + 
				"      \"Tijucas do Sul\",\r\n" + 
				"      \"Toledo\",\r\n" + 
				"      \"Tomazina\",\r\n" + 
				"      \"Três Barras do Paraná\",\r\n" + 
				"      \"Tunas do Paraná\",\r\n" + 
				"      \"Tuneiras do Oeste\",\r\n" + 
				"      \"Tupãssi\",\r\n" + 
				"      \"Turvo\",\r\n" + 
				"      \"Ubiratã\",\r\n" + 
				"      \"Umuarama\",\r\n" + 
				"      \"União da Vitória\",\r\n" + 
				"      \"Uniflor\",\r\n" + 
				"      \"Uraí\",\r\n" + 
				"      \"Ventania\",\r\n" + 
				"      \"Vera Cruz do Oeste\",\r\n" + 
				"      \"Verê\",\r\n" + 
				"      \"Vila Alta\",\r\n" + 
				"      \"Virmond\",\r\n" + 
				"      \"Vitorino\",\r\n" + 
				"      \"Wenceslau Braz\",\r\n" + 
				"      \"Xambrê\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"RJ\",\r\n" + 
				"    \"nome\": \"Rio de Janeiro\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Angra dos Reis\",\r\n" + 
				"      \"Aperibé\",\r\n" + 
				"      \"Araruama\",\r\n" + 
				"      \"Areal\",\r\n" + 
				"      \"Armação de Búzios\",\r\n" + 
				"      \"Arraial do Cabo\",\r\n" + 
				"      \"Barra do Piraí\",\r\n" + 
				"      \"Barra Mansa\",\r\n" + 
				"      \"Belford Roxo\",\r\n" + 
				"      \"Bom Jardim\",\r\n" + 
				"      \"Bom Jesus do Itabapoana\",\r\n" + 
				"      \"Cabo Frio\",\r\n" + 
				"      \"Cachoeiras de Macacu\",\r\n" + 
				"      \"Cambuci\",\r\n" + 
				"      \"Campos dos Goytacazes\",\r\n" + 
				"      \"Cantagalo\",\r\n" + 
				"      \"Carapebus\",\r\n" + 
				"      \"Cardoso Moreira\",\r\n" + 
				"      \"Carmo\",\r\n" + 
				"      \"Casimiro de Abreu\",\r\n" + 
				"      \"Comendador Levy Gasparian\",\r\n" + 
				"      \"Conceição de Macabu\",\r\n" + 
				"      \"Cordeiro\",\r\n" + 
				"      \"Duas Barras\",\r\n" + 
				"      \"Duque de Caxias\",\r\n" + 
				"      \"Engenheiro Paulo de Frontin\",\r\n" + 
				"      \"Guapimirim\",\r\n" + 
				"      \"Iguaba Grande\",\r\n" + 
				"      \"Itaboraí\",\r\n" + 
				"      \"Itaguaí\",\r\n" + 
				"      \"Italva\",\r\n" + 
				"      \"Itaocara\",\r\n" + 
				"      \"Itaperuna\",\r\n" + 
				"      \"Itatiaia\",\r\n" + 
				"      \"Japeri\",\r\n" + 
				"      \"Laje do Muriaé\",\r\n" + 
				"      \"Macaé\",\r\n" + 
				"      \"Macuco\",\r\n" + 
				"      \"Magé\",\r\n" + 
				"      \"Mangaratiba\",\r\n" + 
				"      \"Maricá\",\r\n" + 
				"      \"Mendes\",\r\n" + 
				"      \"Mesquita\",\r\n" + 
				"      \"Miguel Pereira\",\r\n" + 
				"      \"Miracema\",\r\n" + 
				"      \"Natividade\",\r\n" + 
				"      \"Nilópolis\",\r\n" + 
				"      \"Niterói\",\r\n" + 
				"      \"Nova Friburgo\",\r\n" + 
				"      \"Nova Iguaçu\",\r\n" + 
				"      \"Paracambi\",\r\n" + 
				"      \"Paraíba do Sul\",\r\n" + 
				"      \"Parati\",\r\n" + 
				"      \"Paty do Alferes\",\r\n" + 
				"      \"Petrópolis\",\r\n" + 
				"      \"Pinheiral\",\r\n" + 
				"      \"Piraí\",\r\n" + 
				"      \"Porciúncula\",\r\n" + 
				"      \"Porto Real\",\r\n" + 
				"      \"Quatis\",\r\n" + 
				"      \"Queimados\",\r\n" + 
				"      \"Quissamã\",\r\n" + 
				"      \"Resende\",\r\n" + 
				"      \"Rio Bonito\",\r\n" + 
				"      \"Rio Claro\",\r\n" + 
				"      \"Rio das Flores\",\r\n" + 
				"      \"Rio das Ostras\",\r\n" + 
				"      \"Rio de Janeiro\",\r\n" + 
				"      \"Santa Maria Madalena\",\r\n" + 
				"      \"Santo Antônio de Pádua\",\r\n" + 
				"      \"São Fidélis\",\r\n" + 
				"      \"São Francisco de Itabapoana\",\r\n" + 
				"      \"São Gonçalo\",\r\n" + 
				"      \"São João da Barra\",\r\n" + 
				"      \"São João de Meriti\",\r\n" + 
				"      \"São José de Ubá\",\r\n" + 
				"      \"São José do Vale do Rio Preto\",\r\n" + 
				"      \"São Pedro da Aldeia\",\r\n" + 
				"      \"São Sebastião do Alto\",\r\n" + 
				"      \"Sapucaia\",\r\n" + 
				"      \"Saquarema\",\r\n" + 
				"      \"Seropédica\",\r\n" + 
				"      \"Silva Jardim\",\r\n" + 
				"      \"Sumidouro\",\r\n" + 
				"      \"Tanguá\",\r\n" + 
				"      \"Teresópolis\",\r\n" + 
				"      \"Trajano de Morais\",\r\n" + 
				"      \"Três Rios\",\r\n" + 
				"      \"Valença\",\r\n" + 
				"      \"Varre-Sai\",\r\n" + 
				"      \"Vassouras\",\r\n" + 
				"      \"Volta Redonda\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"RN\",\r\n" + 
				"    \"nome\": \"Rio Grande do Norte\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Acari\",\r\n" + 
				"      \"Açu\",\r\n" + 
				"      \"Afonso Bezerra\",\r\n" + 
				"      \"Água Nova\",\r\n" + 
				"      \"Alexandria\",\r\n" + 
				"      \"Almino Afonso\",\r\n" + 
				"      \"Alto do Rodrigues\",\r\n" + 
				"      \"Angicos\",\r\n" + 
				"      \"Antônio Martins\",\r\n" + 
				"      \"Apodi\",\r\n" + 
				"      \"Areia Branca\",\r\n" + 
				"      \"Arês\",\r\n" + 
				"      \"Augusto Severo\",\r\n" + 
				"      \"Baía Formosa\",\r\n" + 
				"      \"Baraúna\",\r\n" + 
				"      \"Barcelona\",\r\n" + 
				"      \"Bento Fernandes\",\r\n" + 
				"      \"Bodó\",\r\n" + 
				"      \"Bom Jesus\",\r\n" + 
				"      \"Brejinho\",\r\n" + 
				"      \"Caiçara do Norte\",\r\n" + 
				"      \"Caiçara do Rio do Vento\",\r\n" + 
				"      \"Caicó\",\r\n" + 
				"      \"Campo Redondo\",\r\n" + 
				"      \"Canguaretama\",\r\n" + 
				"      \"Caraúbas\",\r\n" + 
				"      \"Carnaúba dos Dantas\",\r\n" + 
				"      \"Carnaubais\",\r\n" + 
				"      \"Ceará-Mirim\",\r\n" + 
				"      \"Cerro Corá\",\r\n" + 
				"      \"Coronel Ezequiel\",\r\n" + 
				"      \"Coronel João Pessoa\",\r\n" + 
				"      \"Cruzeta\",\r\n" + 
				"      \"Currais Novos\",\r\n" + 
				"      \"Doutor Severiano\",\r\n" + 
				"      \"Encanto\",\r\n" + 
				"      \"Equador\",\r\n" + 
				"      \"Espírito Santo\",\r\n" + 
				"      \"Extremoz\",\r\n" + 
				"      \"Felipe Guerra\",\r\n" + 
				"      \"Fernando Pedroza\",\r\n" + 
				"      \"Florânia\",\r\n" + 
				"      \"Francisco Dantas\",\r\n" + 
				"      \"Frutuoso Gomes\",\r\n" + 
				"      \"Galinhos\",\r\n" + 
				"      \"Goianinha\",\r\n" + 
				"      \"Governador Dix-Sept Rosado\",\r\n" + 
				"      \"Grossos\",\r\n" + 
				"      \"Guamaré\",\r\n" + 
				"      \"Ielmo Marinho\",\r\n" + 
				"      \"Ipanguaçu\",\r\n" + 
				"      \"Ipueira\",\r\n" + 
				"      \"Itajá\",\r\n" + 
				"      \"Itaú\",\r\n" + 
				"      \"Jaçanã\",\r\n" + 
				"      \"Jandaíra\",\r\n" + 
				"      \"Janduís\",\r\n" + 
				"      \"Januário Cicco\",\r\n" + 
				"      \"Japi\",\r\n" + 
				"      \"Jardim de Angicos\",\r\n" + 
				"      \"Jardim de Piranhas\",\r\n" + 
				"      \"Jardim do Seridó\",\r\n" + 
				"      \"João Câmara\",\r\n" + 
				"      \"João Dias\",\r\n" + 
				"      \"José da Penha\",\r\n" + 
				"      \"Jucurutu\",\r\n" + 
				"      \"Jundiá\",\r\n" + 
				"      \"Lagoa d'Anta\",\r\n" + 
				"      \"Lagoa de Pedras\",\r\n" + 
				"      \"Lagoa de Velhos\",\r\n" + 
				"      \"Lagoa Nova\",\r\n" + 
				"      \"Lagoa Salgada\",\r\n" + 
				"      \"Lajes\",\r\n" + 
				"      \"Lajes Pintadas\",\r\n" + 
				"      \"Lucrécia\",\r\n" + 
				"      \"Luís Gomes\",\r\n" + 
				"      \"Macaíba\",\r\n" + 
				"      \"Macau\",\r\n" + 
				"      \"Major Sales\",\r\n" + 
				"      \"Marcelino Vieira\",\r\n" + 
				"      \"Martins\",\r\n" + 
				"      \"Maxaranguape\",\r\n" + 
				"      \"Messias Targino\",\r\n" + 
				"      \"Montanhas\",\r\n" + 
				"      \"Monte Alegre\",\r\n" + 
				"      \"Monte das Gameleiras\",\r\n" + 
				"      \"Mossoró\",\r\n" + 
				"      \"Natal\",\r\n" + 
				"      \"Nísia Floresta\",\r\n" + 
				"      \"Nova Cruz\",\r\n" + 
				"      \"Olho-d'Água do Borges\",\r\n" + 
				"      \"Ouro Branco\",\r\n" + 
				"      \"Paraná\",\r\n" + 
				"      \"Paraú\",\r\n" + 
				"      \"Parazinho\",\r\n" + 
				"      \"Parelhas\",\r\n" + 
				"      \"Parnamirim\",\r\n" + 
				"      \"Passa e Fica\",\r\n" + 
				"      \"Passagem\",\r\n" + 
				"      \"Patu\",\r\n" + 
				"      \"Pau dos Ferros\",\r\n" + 
				"      \"Pedra Grande\",\r\n" + 
				"      \"Pedra Preta\",\r\n" + 
				"      \"Pedro Avelino\",\r\n" + 
				"      \"Pedro Velho\",\r\n" + 
				"      \"Pendências\",\r\n" + 
				"      \"Pilões\",\r\n" + 
				"      \"Poço Branco\",\r\n" + 
				"      \"Portalegre\",\r\n" + 
				"      \"Porto do Mangue\",\r\n" + 
				"      \"Presidente Juscelino\",\r\n" + 
				"      \"Pureza\",\r\n" + 
				"      \"Rafael Fernandes\",\r\n" + 
				"      \"Rafael Godeiro\",\r\n" + 
				"      \"Riacho da Cruz\",\r\n" + 
				"      \"Riacho de Santana\",\r\n" + 
				"      \"Riachuelo\",\r\n" + 
				"      \"Rio do Fogo\",\r\n" + 
				"      \"Rodolfo Fernandes\",\r\n" + 
				"      \"Ruy Barbosa\",\r\n" + 
				"      \"Santa Cruz\",\r\n" + 
				"      \"Santa Maria\",\r\n" + 
				"      \"Santana do Matos\",\r\n" + 
				"      \"Santana do Seridó\",\r\n" + 
				"      \"Santo Antônio\",\r\n" + 
				"      \"São Bento do Norte\",\r\n" + 
				"      \"São Bento do Trairí\",\r\n" + 
				"      \"São Fernando\",\r\n" + 
				"      \"São Francisco do Oeste\",\r\n" + 
				"      \"São Gonçalo do Amarante\",\r\n" + 
				"      \"São João do Sabugi\",\r\n" + 
				"      \"São José de Mipibu\",\r\n" + 
				"      \"São José do Campestre\",\r\n" + 
				"      \"São José do Seridó\",\r\n" + 
				"      \"São Miguel\",\r\n" + 
				"      \"São Miguel de Touros\",\r\n" + 
				"      \"São Paulo do Potengi\",\r\n" + 
				"      \"São Pedro\",\r\n" + 
				"      \"São Rafael\",\r\n" + 
				"      \"São Tomé\",\r\n" + 
				"      \"São Vicente\",\r\n" + 
				"      \"Senador Elói de Souza\",\r\n" + 
				"      \"Senador Georgino Avelino\",\r\n" + 
				"      \"Serra de São Bento\",\r\n" + 
				"      \"Serra do Mel\",\r\n" + 
				"      \"Serra Negra do Norte\",\r\n" + 
				"      \"Serrinha\",\r\n" + 
				"      \"Serrinha dos Pintos\",\r\n" + 
				"      \"Severiano Melo\",\r\n" + 
				"      \"Sítio Novo\",\r\n" + 
				"      \"Taboleiro Grande\",\r\n" + 
				"      \"Taipu\",\r\n" + 
				"      \"Tangará\",\r\n" + 
				"      \"Tenente Ananias\",\r\n" + 
				"      \"Tenente Laurentino Cruz\",\r\n" + 
				"      \"Tibau\",\r\n" + 
				"      \"Tibau do Sul\",\r\n" + 
				"      \"Timbaúba dos Batistas\",\r\n" + 
				"      \"Touros\",\r\n" + 
				"      \"Triunfo Potiguar\",\r\n" + 
				"      \"Umarizal\",\r\n" + 
				"      \"Upanema\",\r\n" + 
				"      \"Várzea\",\r\n" + 
				"      \"Venha-Ver\",\r\n" + 
				"      \"Vera Cruz\",\r\n" + 
				"      \"Viçosa\",\r\n" + 
				"      \"Vila Flor\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"RO\",\r\n" + 
				"    \"nome\": \"Rondônia\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Alta Floresta d'Oeste\",\r\n" + 
				"      \"Alto Alegre do Parecis\",\r\n" + 
				"      \"Alto Paraíso\",\r\n" + 
				"      \"Alvorada d'Oeste\",\r\n" + 
				"      \"Ariquemes\",\r\n" + 
				"      \"Buritis\",\r\n" + 
				"      \"Cabixi\",\r\n" + 
				"      \"Cacaulândia\",\r\n" + 
				"      \"Cacoal\",\r\n" + 
				"      \"Campo Novo de Rondônia\",\r\n" + 
				"      \"Candeias do Jamari\",\r\n" + 
				"      \"Castanheiras\",\r\n" + 
				"      \"Cerejeiras\",\r\n" + 
				"      \"Chupinguaia\",\r\n" + 
				"      \"Colorado do Oeste\",\r\n" + 
				"      \"Corumbiara\",\r\n" + 
				"      \"Costa Marques\",\r\n" + 
				"      \"Cujubim\",\r\n" + 
				"      \"Espigão d'Oeste\",\r\n" + 
				"      \"Governador Jorge Teixeira\",\r\n" + 
				"      \"Guajará-Mirim\",\r\n" + 
				"      \"Itapuã do Oeste\",\r\n" + 
				"      \"Jaru\",\r\n" + 
				"      \"Ji-Paraná\",\r\n" + 
				"      \"Machadinho d'Oeste\",\r\n" + 
				"      \"Ministro Andreazza\",\r\n" + 
				"      \"Mirante da Serra\",\r\n" + 
				"      \"Monte Negro\",\r\n" + 
				"      \"Nova Brasilândia d'Oeste\",\r\n" + 
				"      \"Nova Mamoré\",\r\n" + 
				"      \"Nova União\",\r\n" + 
				"      \"Novo Horizonte do Oeste\",\r\n" + 
				"      \"Ouro Preto do Oeste\",\r\n" + 
				"      \"Parecis\",\r\n" + 
				"      \"Pimenta Bueno\",\r\n" + 
				"      \"Pimenteiras do Oeste\",\r\n" + 
				"      \"Porto Velho\",\r\n" + 
				"      \"Presidente Médici\",\r\n" + 
				"      \"Primavera de Rondônia\",\r\n" + 
				"      \"Rio Crespo\",\r\n" + 
				"      \"Rolim de Moura\",\r\n" + 
				"      \"Santa Luzia d'Oeste\",\r\n" + 
				"      \"São Felipe d'Oeste\",\r\n" + 
				"      \"São Francisco do Guaporé\",\r\n" + 
				"      \"São Miguel do Guaporé\",\r\n" + 
				"      \"Seringueiras\",\r\n" + 
				"      \"Teixeirópolis\",\r\n" + 
				"      \"Theobroma\",\r\n" + 
				"      \"Urupá\",\r\n" + 
				"      \"Vale do Anari\",\r\n" + 
				"      \"Vale do Paraíso\",\r\n" + 
				"      \"Vilhena\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"RR\",\r\n" + 
				"    \"nome\": \"Roraima\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Alto Alegre\",\r\n" + 
				"      \"Amajari\",\r\n" + 
				"      \"Boa Vista\",\r\n" + 
				"      \"Bonfim\",\r\n" + 
				"      \"Cantá\",\r\n" + 
				"      \"Caracaraí\",\r\n" + 
				"      \"Caroebe\",\r\n" + 
				"      \"Iracema\",\r\n" + 
				"      \"Mucajaí\",\r\n" + 
				"      \"Normandia\",\r\n" + 
				"      \"Pacaraima\",\r\n" + 
				"      \"Rorainópolis\",\r\n" + 
				"      \"São João da Baliza\",\r\n" + 
				"      \"São Luiz\",\r\n" + 
				"      \"Uiramutã\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"RS\",\r\n" + 
				"    \"nome\": \"Rio Grande do Sul\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Aceguá\",\r\n" + 
				"      \"Água Santa\",\r\n" + 
				"      \"Agudo\",\r\n" + 
				"      \"Ajuricaba\",\r\n" + 
				"      \"Alecrim\",\r\n" + 
				"      \"Alegrete\",\r\n" + 
				"      \"Alegria\",\r\n" + 
				"      \"Almirante Tamandaré do Sul\",\r\n" + 
				"      \"Alpestre\",\r\n" + 
				"      \"Alto Alegre\",\r\n" + 
				"      \"Alto Feliz\",\r\n" + 
				"      \"Alvorada\",\r\n" + 
				"      \"Amaral Ferrador\",\r\n" + 
				"      \"Ametista do Sul\",\r\n" + 
				"      \"André da Rocha\",\r\n" + 
				"      \"Anta Gorda\",\r\n" + 
				"      \"Antônio Prado\",\r\n" + 
				"      \"Arambaré\",\r\n" + 
				"      \"Araricá\",\r\n" + 
				"      \"Aratiba\",\r\n" + 
				"      \"Arroio do Meio\",\r\n" + 
				"      \"Arroio do Padre\",\r\n" + 
				"      \"Arroio do Sal\",\r\n" + 
				"      \"Arroio do Tigre\",\r\n" + 
				"      \"Arroio dos Ratos\",\r\n" + 
				"      \"Arroio Grande\",\r\n" + 
				"      \"Arvorezinha\",\r\n" + 
				"      \"Augusto Pestana\",\r\n" + 
				"      \"Áurea\",\r\n" + 
				"      \"Bagé\",\r\n" + 
				"      \"Balneário Pinhal\",\r\n" + 
				"      \"Barão\",\r\n" + 
				"      \"Barão de Cotegipe\",\r\n" + 
				"      \"Barão do Triunfo\",\r\n" + 
				"      \"Barra do Guarita\",\r\n" + 
				"      \"Barra do Quaraí\",\r\n" + 
				"      \"Barra do Ribeiro\",\r\n" + 
				"      \"Barra do Rio Azul\",\r\n" + 
				"      \"Barra Funda\",\r\n" + 
				"      \"Barracão\",\r\n" + 
				"      \"Barros Cassal\",\r\n" + 
				"      \"Benjamin Constan do Sul\",\r\n" + 
				"      \"Bento Gonçalves\",\r\n" + 
				"      \"Boa Vista das Missões\",\r\n" + 
				"      \"Boa Vista do Buricá\",\r\n" + 
				"      \"Boa Vista do Cadeado\",\r\n" + 
				"      \"Boa Vista do Incra\",\r\n" + 
				"      \"Boa Vista do Sul\",\r\n" + 
				"      \"Bom Jesus\",\r\n" + 
				"      \"Bom Princípio\",\r\n" + 
				"      \"Bom Progresso\",\r\n" + 
				"      \"Bom Retiro do Sul\",\r\n" + 
				"      \"Boqueirão do Leão\",\r\n" + 
				"      \"Bossoroca\",\r\n" + 
				"      \"Bozano\",\r\n" + 
				"      \"Braga\",\r\n" + 
				"      \"Brochier\",\r\n" + 
				"      \"Butiá\",\r\n" + 
				"      \"Caçapava do Sul\",\r\n" + 
				"      \"Cacequi\",\r\n" + 
				"      \"Cachoeira do Sul\",\r\n" + 
				"      \"Cachoeirinha\",\r\n" + 
				"      \"Cacique Doble\",\r\n" + 
				"      \"Caibaté\",\r\n" + 
				"      \"Caiçara\",\r\n" + 
				"      \"Camaquã\",\r\n" + 
				"      \"Camargo\",\r\n" + 
				"      \"Cambará do Sul\",\r\n" + 
				"      \"Campestre da Serra\",\r\n" + 
				"      \"Campina das Missões\",\r\n" + 
				"      \"Campinas do Sul\",\r\n" + 
				"      \"Campo Bom\",\r\n" + 
				"      \"Campo Novo\",\r\n" + 
				"      \"Campos Borges\",\r\n" + 
				"      \"Candelária\",\r\n" + 
				"      \"Cândido Godói\",\r\n" + 
				"      \"Candiota\",\r\n" + 
				"      \"Canela\",\r\n" + 
				"      \"Canguçu\",\r\n" + 
				"      \"Canoas\",\r\n" + 
				"      \"Canudos do Vale\",\r\n" + 
				"      \"Capão Bonito do Sul\",\r\n" + 
				"      \"Capão da Canoa\",\r\n" + 
				"      \"Capão do Cipó\",\r\n" + 
				"      \"Capão do Leão\",\r\n" + 
				"      \"Capela de Santana\",\r\n" + 
				"      \"Capitão\",\r\n" + 
				"      \"Capivari do Sul\",\r\n" + 
				"      \"Caraá\",\r\n" + 
				"      \"Carazinho\",\r\n" + 
				"      \"Carlos Barbosa\",\r\n" + 
				"      \"Carlos Gomes\",\r\n" + 
				"      \"Casca\",\r\n" + 
				"      \"Caseiros\",\r\n" + 
				"      \"Catuípe\",\r\n" + 
				"      \"Caxias do Sul\",\r\n" + 
				"      \"Centenário\",\r\n" + 
				"      \"Cerrito\",\r\n" + 
				"      \"Cerro Branco\",\r\n" + 
				"      \"Cerro Grande\",\r\n" + 
				"      \"Cerro Grande do Sul\",\r\n" + 
				"      \"Cerro Largo\",\r\n" + 
				"      \"Chapada\",\r\n" + 
				"      \"Charqueadas\",\r\n" + 
				"      \"Charrua\",\r\n" + 
				"      \"Chiapeta\",\r\n" + 
				"      \"Chuí\",\r\n" + 
				"      \"Chuvisca\",\r\n" + 
				"      \"Cidreira\",\r\n" + 
				"      \"Ciríaco\",\r\n" + 
				"      \"Colinas\",\r\n" + 
				"      \"Colorado\",\r\n" + 
				"      \"Condor\",\r\n" + 
				"      \"Constantina\",\r\n" + 
				"      \"Coqueiro Baixo\",\r\n" + 
				"      \"Coqueiros do Sul\",\r\n" + 
				"      \"Coronel Barros\",\r\n" + 
				"      \"Coronel Bicaco\",\r\n" + 
				"      \"Coronel Pilar\",\r\n" + 
				"      \"Cotiporã\",\r\n" + 
				"      \"Coxilha\",\r\n" + 
				"      \"Crissiumal\",\r\n" + 
				"      \"Cristal\",\r\n" + 
				"      \"Cristal do Sul\",\r\n" + 
				"      \"Cruz Alta\",\r\n" + 
				"      \"Cruzaltense\",\r\n" + 
				"      \"Cruzeiro do Sul\",\r\n" + 
				"      \"David Canabarro\",\r\n" + 
				"      \"Derrubadas\",\r\n" + 
				"      \"Dezesseis de Novembro\",\r\n" + 
				"      \"Dilermando de Aguiar\",\r\n" + 
				"      \"Dois Irmãos\",\r\n" + 
				"      \"Dois Irmãos das Missões\",\r\n" + 
				"      \"Dois Lajeados\",\r\n" + 
				"      \"Dom Feliciano\",\r\n" + 
				"      \"Dom Pedrito\",\r\n" + 
				"      \"Dom Pedro de Alcântara\",\r\n" + 
				"      \"Dona Francisca\",\r\n" + 
				"      \"Doutor Maurício Cardoso\",\r\n" + 
				"      \"Doutor Ricardo\",\r\n" + 
				"      \"Eldorado do Sul\",\r\n" + 
				"      \"Encantado\",\r\n" + 
				"      \"Encruzilhada do Sul\",\r\n" + 
				"      \"Engenho Velho\",\r\n" + 
				"      \"Entre Rios do Sul\",\r\n" + 
				"      \"Entre-Ijuís\",\r\n" + 
				"      \"Erebango\",\r\n" + 
				"      \"Erechim\",\r\n" + 
				"      \"Ernestina\",\r\n" + 
				"      \"Erval Grande\",\r\n" + 
				"      \"Erval Seco\",\r\n" + 
				"      \"Esmeralda\",\r\n" + 
				"      \"Esperança do Sul\",\r\n" + 
				"      \"Espumoso\",\r\n" + 
				"      \"Estação\",\r\n" + 
				"      \"Estância Velha\",\r\n" + 
				"      \"Esteio\",\r\n" + 
				"      \"Estrela\",\r\n" + 
				"      \"Estrela Velha\",\r\n" + 
				"      \"Eugênio de Castro\",\r\n" + 
				"      \"Fagundes Varela\",\r\n" + 
				"      \"Farroupilha\",\r\n" + 
				"      \"Faxinal do Soturno\",\r\n" + 
				"      \"Faxinalzinho\",\r\n" + 
				"      \"Fazenda Vilanova\",\r\n" + 
				"      \"Feliz\",\r\n" + 
				"      \"Flores da Cunha\",\r\n" + 
				"      \"Floriano Peixoto\",\r\n" + 
				"      \"Fontoura Xavier\",\r\n" + 
				"      \"Formigueiro\",\r\n" + 
				"      \"Forquetinha\",\r\n" + 
				"      \"Fortaleza dos Valos\",\r\n" + 
				"      \"Frederico Westphalen\",\r\n" + 
				"      \"Garibaldi\",\r\n" + 
				"      \"Garruchos\",\r\n" + 
				"      \"Gaurama\",\r\n" + 
				"      \"General Câmara\",\r\n" + 
				"      \"Gentil\",\r\n" + 
				"      \"Getúlio Vargas\",\r\n" + 
				"      \"Giruá\",\r\n" + 
				"      \"Glorinha\",\r\n" + 
				"      \"Gramado\",\r\n" + 
				"      \"Gramado dos Loureiros\",\r\n" + 
				"      \"Gramado Xavier\",\r\n" + 
				"      \"Gravataí\",\r\n" + 
				"      \"Guabiju\",\r\n" + 
				"      \"Guaíba\",\r\n" + 
				"      \"Guaporé\",\r\n" + 
				"      \"Guarani das Missões\",\r\n" + 
				"      \"Harmonia\",\r\n" + 
				"      \"Herval\",\r\n" + 
				"      \"Herveiras\",\r\n" + 
				"      \"Horizontina\",\r\n" + 
				"      \"Hulha Negra\",\r\n" + 
				"      \"Humaitá\",\r\n" + 
				"      \"Ibarama\",\r\n" + 
				"      \"Ibiaçá\",\r\n" + 
				"      \"Ibiraiaras\",\r\n" + 
				"      \"Ibirapuitã\",\r\n" + 
				"      \"Ibirubá\",\r\n" + 
				"      \"Igrejinha\",\r\n" + 
				"      \"Ijuí\",\r\n" + 
				"      \"Ilópolis\",\r\n" + 
				"      \"Imbé\",\r\n" + 
				"      \"Imigrante\",\r\n" + 
				"      \"Independência\",\r\n" + 
				"      \"Inhacorá\",\r\n" + 
				"      \"Ipê\",\r\n" + 
				"      \"Ipiranga do Sul\",\r\n" + 
				"      \"Iraí\",\r\n" + 
				"      \"Itaara\",\r\n" + 
				"      \"Itacurubi\",\r\n" + 
				"      \"Itapuca\",\r\n" + 
				"      \"Itaqui\",\r\n" + 
				"      \"Itati\",\r\n" + 
				"      \"Itatiba do Sul\",\r\n" + 
				"      \"Ivorá\",\r\n" + 
				"      \"Ivoti\",\r\n" + 
				"      \"Jaboticaba\",\r\n" + 
				"      \"Jacuizinho\",\r\n" + 
				"      \"Jacutinga\",\r\n" + 
				"      \"Jaguarão\",\r\n" + 
				"      \"Jaguari\",\r\n" + 
				"      \"Jaquirana\",\r\n" + 
				"      \"Jari\",\r\n" + 
				"      \"Jóia\",\r\n" + 
				"      \"Júlio de Castilhos\",\r\n" + 
				"      \"Lagoa Bonita do Sul\",\r\n" + 
				"      \"Lagoa dos Três Cantos\",\r\n" + 
				"      \"Lagoa Vermelha\",\r\n" + 
				"      \"Lagoão\",\r\n" + 
				"      \"Lajeado\",\r\n" + 
				"      \"Lajeado do Bugre\",\r\n" + 
				"      \"Lavras do Sul\",\r\n" + 
				"      \"Liberato Salzano\",\r\n" + 
				"      \"Lindolfo Collor\",\r\n" + 
				"      \"Linha Nova\",\r\n" + 
				"      \"Maçambara\",\r\n" + 
				"      \"Machadinho\",\r\n" + 
				"      \"Mampituba\",\r\n" + 
				"      \"Manoel Viana\",\r\n" + 
				"      \"Maquiné\",\r\n" + 
				"      \"Maratá\",\r\n" + 
				"      \"Marau\",\r\n" + 
				"      \"Marcelino Ramos\",\r\n" + 
				"      \"Mariana Pimentel\",\r\n" + 
				"      \"Mariano Moro\",\r\n" + 
				"      \"Marques de Souza\",\r\n" + 
				"      \"Mata\",\r\n" + 
				"      \"Mato Castelhano\",\r\n" + 
				"      \"Mato Leitão\",\r\n" + 
				"      \"Mato Queimado\",\r\n" + 
				"      \"Maximiliano de Almeida\",\r\n" + 
				"      \"Minas do Leão\",\r\n" + 
				"      \"Miraguaí\",\r\n" + 
				"      \"Montauri\",\r\n" + 
				"      \"Monte Alegre dos Campos\",\r\n" + 
				"      \"Monte Belo do Sul\",\r\n" + 
				"      \"Montenegro\",\r\n" + 
				"      \"Mormaço\",\r\n" + 
				"      \"Morrinhos do Sul\",\r\n" + 
				"      \"Morro Redondo\",\r\n" + 
				"      \"Morro Reuter\",\r\n" + 
				"      \"Mostardas\",\r\n" + 
				"      \"Muçum\",\r\n" + 
				"      \"Muitos Capões\",\r\n" + 
				"      \"Muliterno\",\r\n" + 
				"      \"Não-Me-Toque\",\r\n" + 
				"      \"Nicolau Vergueiro\",\r\n" + 
				"      \"Nonoai\",\r\n" + 
				"      \"Nova Alvorada\",\r\n" + 
				"      \"Nova Araçá\",\r\n" + 
				"      \"Nova Bassano\",\r\n" + 
				"      \"Nova Boa Vista\",\r\n" + 
				"      \"Nova Bréscia\",\r\n" + 
				"      \"Nova Candelária\",\r\n" + 
				"      \"Nova Esperança do Sul\",\r\n" + 
				"      \"Nova Hartz\",\r\n" + 
				"      \"Nova Pádua\",\r\n" + 
				"      \"Nova Palma\",\r\n" + 
				"      \"Nova Petrópolis\",\r\n" + 
				"      \"Nova Prata\",\r\n" + 
				"      \"Nova Ramada\",\r\n" + 
				"      \"Nova Roma do Sul\",\r\n" + 
				"      \"Nova Santa Rita\",\r\n" + 
				"      \"Novo Barreiro\",\r\n" + 
				"      \"Novo Cabrais\",\r\n" + 
				"      \"Novo Hamburgo\",\r\n" + 
				"      \"Novo Machado\",\r\n" + 
				"      \"Novo Tiradentes\",\r\n" + 
				"      \"Novo Xingu\",\r\n" + 
				"      \"Osório\",\r\n" + 
				"      \"Paim Filho\",\r\n" + 
				"      \"Palmares do Sul\",\r\n" + 
				"      \"Palmeira das Missões\",\r\n" + 
				"      \"Palmitinho\",\r\n" + 
				"      \"Panambi\",\r\n" + 
				"      \"Pântano Grande\",\r\n" + 
				"      \"Paraí\",\r\n" + 
				"      \"Paraíso do Sul\",\r\n" + 
				"      \"Pareci Novo\",\r\n" + 
				"      \"Parobé\",\r\n" + 
				"      \"Passa Sete\",\r\n" + 
				"      \"Passo do Sobrado\",\r\n" + 
				"      \"Passo Fundo\",\r\n" + 
				"      \"Paulo Bento\",\r\n" + 
				"      \"Paverama\",\r\n" + 
				"      \"Pedras Altas\",\r\n" + 
				"      \"Pedro Osório\",\r\n" + 
				"      \"Pejuçara\",\r\n" + 
				"      \"Pelotas\",\r\n" + 
				"      \"Picada Café\",\r\n" + 
				"      \"Pinhal\",\r\n" + 
				"      \"Pinhal da Serra\",\r\n" + 
				"      \"Pinhal Grande\",\r\n" + 
				"      \"Pinheirinho do Vale\",\r\n" + 
				"      \"Pinheiro Machado\",\r\n" + 
				"      \"Pirapó\",\r\n" + 
				"      \"Piratini\",\r\n" + 
				"      \"Planalto\",\r\n" + 
				"      \"Poço das Antas\",\r\n" + 
				"      \"Pontão\",\r\n" + 
				"      \"Ponte Preta\",\r\n" + 
				"      \"Portão\",\r\n" + 
				"      \"Porto Alegre\",\r\n" + 
				"      \"Porto Lucena\",\r\n" + 
				"      \"Porto Mauá\",\r\n" + 
				"      \"Porto Vera Cruz\",\r\n" + 
				"      \"Porto Xavier\",\r\n" + 
				"      \"Pouso Novo\",\r\n" + 
				"      \"Presidente Lucena\",\r\n" + 
				"      \"Progresso\",\r\n" + 
				"      \"Protásio Alves\",\r\n" + 
				"      \"Putinga\",\r\n" + 
				"      \"Quaraí\",\r\n" + 
				"      \"Quatro Irmãos\",\r\n" + 
				"      \"Quevedos\",\r\n" + 
				"      \"Quinze de Novembro\",\r\n" + 
				"      \"Redentora\",\r\n" + 
				"      \"Relvado\",\r\n" + 
				"      \"Restinga Seca\",\r\n" + 
				"      \"Rio dos Índios\",\r\n" + 
				"      \"Rio Grande\",\r\n" + 
				"      \"Rio Pardo\",\r\n" + 
				"      \"Riozinho\",\r\n" + 
				"      \"Roca Sales\",\r\n" + 
				"      \"Rodeio Bonito\",\r\n" + 
				"      \"Rolador\",\r\n" + 
				"      \"Rolante\",\r\n" + 
				"      \"Ronda Alta\",\r\n" + 
				"      \"Rondinha\",\r\n" + 
				"      \"Roque Gonzales\",\r\n" + 
				"      \"Rosário do Sul\",\r\n" + 
				"      \"Sagrada Família\",\r\n" + 
				"      \"Saldanha Marinho\",\r\n" + 
				"      \"Salto do Jacuí\",\r\n" + 
				"      \"Salvador das Missões\",\r\n" + 
				"      \"Salvador do Sul\",\r\n" + 
				"      \"Sananduva\",\r\n" + 
				"      \"Santa Bárbara do Sul\",\r\n" + 
				"      \"Santa Cecília do Sul\",\r\n" + 
				"      \"Santa Clara do Sul\",\r\n" + 
				"      \"Santa Cruz do Sul\",\r\n" + 
				"      \"Santa Margarida do Sul\",\r\n" + 
				"      \"Santa Maria\",\r\n" + 
				"      \"Santa Maria do Herval\",\r\n" + 
				"      \"Santa Rosa\",\r\n" + 
				"      \"Santa Tereza\",\r\n" + 
				"      \"Santa Vitória do Palmar\",\r\n" + 
				"      \"Santana da Boa Vista\",\r\n" + 
				"      \"Santana do Livramento\",\r\n" + 
				"      \"Santiago\",\r\n" + 
				"      \"Santo Ângelo\",\r\n" + 
				"      \"Santo Antônio da Patrulha\",\r\n" + 
				"      \"Santo Antônio das Missões\",\r\n" + 
				"      \"Santo Antônio do Palma\",\r\n" + 
				"      \"Santo Antônio do Planalto\",\r\n" + 
				"      \"Santo Augusto\",\r\n" + 
				"      \"Santo Cristo\",\r\n" + 
				"      \"Santo Expedito do Sul\",\r\n" + 
				"      \"São Borja\",\r\n" + 
				"      \"São Domingos do Sul\",\r\n" + 
				"      \"São Francisco de Assis\",\r\n" + 
				"      \"São Francisco de Paula\",\r\n" + 
				"      \"São Gabriel\",\r\n" + 
				"      \"São Jerônimo\",\r\n" + 
				"      \"São João da Urtiga\",\r\n" + 
				"      \"São João do Polêsine\",\r\n" + 
				"      \"São Jorge\",\r\n" + 
				"      \"São José das Missões\",\r\n" + 
				"      \"São José do Herval\",\r\n" + 
				"      \"São José do Hortêncio\",\r\n" + 
				"      \"São José do Inhacorá\",\r\n" + 
				"      \"São José do Norte\",\r\n" + 
				"      \"São José do Ouro\",\r\n" + 
				"      \"São José do Sul\",\r\n" + 
				"      \"São José dos Ausentes\",\r\n" + 
				"      \"São Leopoldo\",\r\n" + 
				"      \"São Lourenço do Sul\",\r\n" + 
				"      \"São Luiz Gonzaga\",\r\n" + 
				"      \"São Marcos\",\r\n" + 
				"      \"São Martinho\",\r\n" + 
				"      \"São Martinho da Serra\",\r\n" + 
				"      \"São Miguel das Missões\",\r\n" + 
				"      \"São Nicolau\",\r\n" + 
				"      \"São Paulo das Missões\",\r\n" + 
				"      \"São Pedro da Serra\",\r\n" + 
				"      \"São Pedro das Missões\",\r\n" + 
				"      \"São Pedro do Butiá\",\r\n" + 
				"      \"São Pedro do Sul\",\r\n" + 
				"      \"São Sebastião do Caí\",\r\n" + 
				"      \"São Sepé\",\r\n" + 
				"      \"São Valentim\",\r\n" + 
				"      \"São Valentim do Sul\",\r\n" + 
				"      \"São Valério do Sul\",\r\n" + 
				"      \"São Vendelino\",\r\n" + 
				"      \"São Vicente do Sul\",\r\n" + 
				"      \"Sapiranga\",\r\n" + 
				"      \"Sapucaia do Sul\",\r\n" + 
				"      \"Sarandi\",\r\n" + 
				"      \"Seberi\",\r\n" + 
				"      \"Sede Nova\",\r\n" + 
				"      \"Segredo\",\r\n" + 
				"      \"Selbach\",\r\n" + 
				"      \"Senador Salgado Filho\",\r\n" + 
				"      \"Sentinela do Sul\",\r\n" + 
				"      \"Serafina Corrêa\",\r\n" + 
				"      \"Sério\",\r\n" + 
				"      \"Sertão\",\r\n" + 
				"      \"Sertão Santana\",\r\n" + 
				"      \"Sete de Setembro\",\r\n" + 
				"      \"Severiano de Almeida\",\r\n" + 
				"      \"Silveira Martins\",\r\n" + 
				"      \"Sinimbu\",\r\n" + 
				"      \"Sobradinho\",\r\n" + 
				"      \"Soledade\",\r\n" + 
				"      \"Tabaí\",\r\n" + 
				"      \"Tapejara\",\r\n" + 
				"      \"Tapera\",\r\n" + 
				"      \"Tapes\",\r\n" + 
				"      \"Taquara\",\r\n" + 
				"      \"Taquari\",\r\n" + 
				"      \"Taquaruçu do Sul\",\r\n" + 
				"      \"Tavares\",\r\n" + 
				"      \"Tenente Portela\",\r\n" + 
				"      \"Terra de Areia\",\r\n" + 
				"      \"Teutônia\",\r\n" + 
				"      \"Tio Hugo\",\r\n" + 
				"      \"Tiradentes do Sul\",\r\n" + 
				"      \"Toropi\",\r\n" + 
				"      \"Torres\",\r\n" + 
				"      \"Tramandaí\",\r\n" + 
				"      \"Travesseiro\",\r\n" + 
				"      \"Três Arroios\",\r\n" + 
				"      \"Três Cachoeiras\",\r\n" + 
				"      \"Três Coroas\",\r\n" + 
				"      \"Três de Maio\",\r\n" + 
				"      \"Três Forquilhas\",\r\n" + 
				"      \"Três Palmeiras\",\r\n" + 
				"      \"Três Passos\",\r\n" + 
				"      \"Trindade do Sul\",\r\n" + 
				"      \"Triunfo\",\r\n" + 
				"      \"Tucunduva\",\r\n" + 
				"      \"Tunas\",\r\n" + 
				"      \"Tupanci do Sul\",\r\n" + 
				"      \"Tupanciretã\",\r\n" + 
				"      \"Tupandi\",\r\n" + 
				"      \"Tuparendi\",\r\n" + 
				"      \"Turuçu\",\r\n" + 
				"      \"Ubiretama\",\r\n" + 
				"      \"União da Serra\",\r\n" + 
				"      \"Unistalda\",\r\n" + 
				"      \"Uruguaiana\",\r\n" + 
				"      \"Vacaria\",\r\n" + 
				"      \"Vale do Sol\",\r\n" + 
				"      \"Vale Real\",\r\n" + 
				"      \"Vale Verde\",\r\n" + 
				"      \"Vanini\",\r\n" + 
				"      \"Venâncio Aires\",\r\n" + 
				"      \"Vera Cruz\",\r\n" + 
				"      \"Veranópolis\",\r\n" + 
				"      \"Vespasiano Correa\",\r\n" + 
				"      \"Viadutos\",\r\n" + 
				"      \"Viamão\",\r\n" + 
				"      \"Vicente Dutra\",\r\n" + 
				"      \"Victor Graeff\",\r\n" + 
				"      \"Vila Flores\",\r\n" + 
				"      \"Vila Lângaro\",\r\n" + 
				"      \"Vila Maria\",\r\n" + 
				"      \"Vila Nova do Sul\",\r\n" + 
				"      \"Vista Alegre\",\r\n" + 
				"      \"Vista Alegre do Prata\",\r\n" + 
				"      \"Vista Gaúcha\",\r\n" + 
				"      \"Vitória das Missões\",\r\n" + 
				"      \"Westfália\",\r\n" + 
				"      \"Xangri-lá\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"SC\",\r\n" + 
				"    \"nome\": \"Santa Catarina\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Abdon Batista\",\r\n" + 
				"      \"Abelardo Luz\",\r\n" + 
				"      \"Agrolândia\",\r\n" + 
				"      \"Agronômica\",\r\n" + 
				"      \"Água Doce\",\r\n" + 
				"      \"Águas de Chapecó\",\r\n" + 
				"      \"Águas Frias\",\r\n" + 
				"      \"Águas Mornas\",\r\n" + 
				"      \"Alfredo Wagner\",\r\n" + 
				"      \"Alto Bela Vista\",\r\n" + 
				"      \"Anchieta\",\r\n" + 
				"      \"Angelina\",\r\n" + 
				"      \"Anita Garibaldi\",\r\n" + 
				"      \"Anitápolis\",\r\n" + 
				"      \"Antônio Carlos\",\r\n" + 
				"      \"Apiúna\",\r\n" + 
				"      \"Arabutã\",\r\n" + 
				"      \"Araquari\",\r\n" + 
				"      \"Araranguá\",\r\n" + 
				"      \"Armazém\",\r\n" + 
				"      \"Arroio Trinta\",\r\n" + 
				"      \"Arvoredo\",\r\n" + 
				"      \"Ascurra\",\r\n" + 
				"      \"Atalanta\",\r\n" + 
				"      \"Aurora\",\r\n" + 
				"      \"Balneário Arroio do Silva\",\r\n" + 
				"      \"Balneário Barra do Sul\",\r\n" + 
				"      \"Balneário Camboriú\",\r\n" + 
				"      \"Balneário Gaivota\",\r\n" + 
				"      \"Bandeirante\",\r\n" + 
				"      \"Barra Bonita\",\r\n" + 
				"      \"Barra Velha\",\r\n" + 
				"      \"Bela Vista do Toldo\",\r\n" + 
				"      \"Belmonte\",\r\n" + 
				"      \"Benedito Novo\",\r\n" + 
				"      \"Biguaçu\",\r\n" + 
				"      \"Blumenau\",\r\n" + 
				"      \"Bocaina do Sul\",\r\n" + 
				"      \"Bom Jardim da Serra\",\r\n" + 
				"      \"Bom Jesus\",\r\n" + 
				"      \"Bom Jesus do Oeste\",\r\n" + 
				"      \"Bom Retiro\",\r\n" + 
				"      \"Bombinhas\",\r\n" + 
				"      \"Botuverá\",\r\n" + 
				"      \"Braço do Norte\",\r\n" + 
				"      \"Braço do Trombudo\",\r\n" + 
				"      \"Brunópolis\",\r\n" + 
				"      \"Brusque\",\r\n" + 
				"      \"Caçador\",\r\n" + 
				"      \"Caibi\",\r\n" + 
				"      \"Calmon\",\r\n" + 
				"      \"Camboriú\",\r\n" + 
				"      \"Campo Alegre\",\r\n" + 
				"      \"Campo Belo do Sul\",\r\n" + 
				"      \"Campo Erê\",\r\n" + 
				"      \"Campos Novos\",\r\n" + 
				"      \"Canelinha\",\r\n" + 
				"      \"Canoinhas\",\r\n" + 
				"      \"Capão Alto\",\r\n" + 
				"      \"Capinzal\",\r\n" + 
				"      \"Capivari de Baixo\",\r\n" + 
				"      \"Catanduvas\",\r\n" + 
				"      \"Caxambu do Sul\",\r\n" + 
				"      \"Celso Ramos\",\r\n" + 
				"      \"Cerro Negro\",\r\n" + 
				"      \"Chapadão do Lageado\",\r\n" + 
				"      \"Chapecó\",\r\n" + 
				"      \"Cocal do Sul\",\r\n" + 
				"      \"Concórdia\",\r\n" + 
				"      \"Cordilheira Alta\",\r\n" + 
				"      \"Coronel Freitas\",\r\n" + 
				"      \"Coronel Martins\",\r\n" + 
				"      \"Correia Pinto\",\r\n" + 
				"      \"Corupá\",\r\n" + 
				"      \"Criciúma\",\r\n" + 
				"      \"Cunha Porã\",\r\n" + 
				"      \"Cunhataí\",\r\n" + 
				"      \"Curitibanos\",\r\n" + 
				"      \"Descanso\",\r\n" + 
				"      \"Dionísio Cerqueira\",\r\n" + 
				"      \"Dona Emma\",\r\n" + 
				"      \"Doutor Pedrinho\",\r\n" + 
				"      \"Entre Rios\",\r\n" + 
				"      \"Ermo\",\r\n" + 
				"      \"Erval Velho\",\r\n" + 
				"      \"Faxinal dos Guedes\",\r\n" + 
				"      \"Flor do Sertão\",\r\n" + 
				"      \"Florianópolis\",\r\n" + 
				"      \"Formosa do Sul\",\r\n" + 
				"      \"Forquilhinha\",\r\n" + 
				"      \"Fraiburgo\",\r\n" + 
				"      \"Frei Rogério\",\r\n" + 
				"      \"Galvão\",\r\n" + 
				"      \"Garopaba\",\r\n" + 
				"      \"Garuva\",\r\n" + 
				"      \"Gaspar\",\r\n" + 
				"      \"Governador Celso Ramos\",\r\n" + 
				"      \"Grão Pará\",\r\n" + 
				"      \"Gravatal\",\r\n" + 
				"      \"Guabiruba\",\r\n" + 
				"      \"Guaraciaba\",\r\n" + 
				"      \"Guaramirim\",\r\n" + 
				"      \"Guarujá do Sul\",\r\n" + 
				"      \"Guatambú\",\r\n" + 
				"      \"Herval d'Oeste\",\r\n" + 
				"      \"Ibiam\",\r\n" + 
				"      \"Ibicaré\",\r\n" + 
				"      \"Ibirama\",\r\n" + 
				"      \"Içara\",\r\n" + 
				"      \"Ilhota\",\r\n" + 
				"      \"Imaruí\",\r\n" + 
				"      \"Imbituba\",\r\n" + 
				"      \"Imbuia\",\r\n" + 
				"      \"Indaial\",\r\n" + 
				"      \"Iomerê\",\r\n" + 
				"      \"Ipira\",\r\n" + 
				"      \"Iporã do Oeste\",\r\n" + 
				"      \"Ipuaçu\",\r\n" + 
				"      \"Ipumirim\",\r\n" + 
				"      \"Iraceminha\",\r\n" + 
				"      \"Irani\",\r\n" + 
				"      \"Irati\",\r\n" + 
				"      \"Irineópolis\",\r\n" + 
				"      \"Itá\",\r\n" + 
				"      \"Itaiópolis\",\r\n" + 
				"      \"Itajaí\",\r\n" + 
				"      \"Itapema\",\r\n" + 
				"      \"Itapiranga\",\r\n" + 
				"      \"Itapoá\",\r\n" + 
				"      \"Ituporanga\",\r\n" + 
				"      \"Jaborá\",\r\n" + 
				"      \"Jacinto Machado\",\r\n" + 
				"      \"Jaguaruna\",\r\n" + 
				"      \"Jaraguá do Sul\",\r\n" + 
				"      \"Jardinópolis\",\r\n" + 
				"      \"Joaçaba\",\r\n" + 
				"      \"Joinville\",\r\n" + 
				"      \"José Boiteux\",\r\n" + 
				"      \"Jupiá\",\r\n" + 
				"      \"Lacerdópolis\",\r\n" + 
				"      \"Lages\",\r\n" + 
				"      \"Laguna\",\r\n" + 
				"      \"Lajeado Grande\",\r\n" + 
				"      \"Laurentino\",\r\n" + 
				"      \"Lauro Muller\",\r\n" + 
				"      \"Lebon Régis\",\r\n" + 
				"      \"Leoberto Leal\",\r\n" + 
				"      \"Lindóia do Sul\",\r\n" + 
				"      \"Lontras\",\r\n" + 
				"      \"Luiz Alves\",\r\n" + 
				"      \"Luzerna\",\r\n" + 
				"      \"Macieira\",\r\n" + 
				"      \"Mafra\",\r\n" + 
				"      \"Major Gercino\",\r\n" + 
				"      \"Major Vieira\",\r\n" + 
				"      \"Maracajá\",\r\n" + 
				"      \"Maravilha\",\r\n" + 
				"      \"Marema\",\r\n" + 
				"      \"Massaranduba\",\r\n" + 
				"      \"Matos Costa\",\r\n" + 
				"      \"Meleiro\",\r\n" + 
				"      \"Mirim Doce\",\r\n" + 
				"      \"Modelo\",\r\n" + 
				"      \"Mondaí\",\r\n" + 
				"      \"Monte Carlo\",\r\n" + 
				"      \"Monte Castelo\",\r\n" + 
				"      \"Morro da Fumaça\",\r\n" + 
				"      \"Morro Grande\",\r\n" + 
				"      \"Navegantes\",\r\n" + 
				"      \"Nova Erechim\",\r\n" + 
				"      \"Nova Itaberaba\",\r\n" + 
				"      \"Nova Trento\",\r\n" + 
				"      \"Nova Veneza\",\r\n" + 
				"      \"Novo Horizonte\",\r\n" + 
				"      \"Orleans\",\r\n" + 
				"      \"Otacílio Costa\",\r\n" + 
				"      \"Ouro\",\r\n" + 
				"      \"Ouro Verde\",\r\n" + 
				"      \"Paial\",\r\n" + 
				"      \"Painel\",\r\n" + 
				"      \"Palhoça\",\r\n" + 
				"      \"Palma Sola\",\r\n" + 
				"      \"Palmeira\",\r\n" + 
				"      \"Palmitos\",\r\n" + 
				"      \"Papanduva\",\r\n" + 
				"      \"Paraíso\",\r\n" + 
				"      \"Passo de Torres\",\r\n" + 
				"      \"Passos Maia\",\r\n" + 
				"      \"Paulo Lopes\",\r\n" + 
				"      \"Pedras Grandes\",\r\n" + 
				"      \"Penha\",\r\n" + 
				"      \"Peritiba\",\r\n" + 
				"      \"Petrolândia\",\r\n" + 
				"      \"Piçarras\",\r\n" + 
				"      \"Pinhalzinho\",\r\n" + 
				"      \"Pinheiro Preto\",\r\n" + 
				"      \"Piratuba\",\r\n" + 
				"      \"Planalto Alegre\",\r\n" + 
				"      \"Pomerode\",\r\n" + 
				"      \"Ponte Alta\",\r\n" + 
				"      \"Ponte Alta do Norte\",\r\n" + 
				"      \"Ponte Serrada\",\r\n" + 
				"      \"Porto Belo\",\r\n" + 
				"      \"Porto União\",\r\n" + 
				"      \"Pouso Redondo\",\r\n" + 
				"      \"Praia Grande\",\r\n" + 
				"      \"Presidente Castelo Branco\",\r\n" + 
				"      \"Presidente Getúlio\",\r\n" + 
				"      \"Presidente Nereu\",\r\n" + 
				"      \"Princesa\",\r\n" + 
				"      \"Quilombo\",\r\n" + 
				"      \"Rancho Queimado\",\r\n" + 
				"      \"Rio das Antas\",\r\n" + 
				"      \"Rio do Campo\",\r\n" + 
				"      \"Rio do Oeste\",\r\n" + 
				"      \"Rio do Sul\",\r\n" + 
				"      \"Rio dos Cedros\",\r\n" + 
				"      \"Rio Fortuna\",\r\n" + 
				"      \"Rio Negrinho\",\r\n" + 
				"      \"Rio Rufino\",\r\n" + 
				"      \"Riqueza\",\r\n" + 
				"      \"Rodeio\",\r\n" + 
				"      \"Romelândia\",\r\n" + 
				"      \"Salete\",\r\n" + 
				"      \"Saltinho\",\r\n" + 
				"      \"Salto Veloso\",\r\n" + 
				"      \"Sangão\",\r\n" + 
				"      \"Santa Cecília\",\r\n" + 
				"      \"Santa Helena\",\r\n" + 
				"      \"Santa Rosa de Lima\",\r\n" + 
				"      \"Santa Rosa do Sul\",\r\n" + 
				"      \"Santa Terezinha\",\r\n" + 
				"      \"Santa Terezinha do Progresso\",\r\n" + 
				"      \"Santiago do Sul\",\r\n" + 
				"      \"Santo Amaro da Imperatriz\",\r\n" + 
				"      \"São Bento do Sul\",\r\n" + 
				"      \"São Bernardino\",\r\n" + 
				"      \"São Bonifácio\",\r\n" + 
				"      \"São Carlos\",\r\n" + 
				"      \"São Cristovão do Sul\",\r\n" + 
				"      \"São Domingos\",\r\n" + 
				"      \"São Francisco do Sul\",\r\n" + 
				"      \"São João Batista\",\r\n" + 
				"      \"São João do Itaperiú\",\r\n" + 
				"      \"São João do Oeste\",\r\n" + 
				"      \"São João do Sul\",\r\n" + 
				"      \"São Joaquim\",\r\n" + 
				"      \"São José\",\r\n" + 
				"      \"São José do Cedro\",\r\n" + 
				"      \"São José do Cerrito\",\r\n" + 
				"      \"São Lourenço do Oeste\",\r\n" + 
				"      \"São Ludgero\",\r\n" + 
				"      \"São Martinho\",\r\n" + 
				"      \"São Miguel da Boa Vista\",\r\n" + 
				"      \"São Miguel do Oeste\",\r\n" + 
				"      \"São Pedro de Alcântara\",\r\n" + 
				"      \"Saudades\",\r\n" + 
				"      \"Schroeder\",\r\n" + 
				"      \"Seara\",\r\n" + 
				"      \"Serra Alta\",\r\n" + 
				"      \"Siderópolis\",\r\n" + 
				"      \"Sombrio\",\r\n" + 
				"      \"Sul Brasil\",\r\n" + 
				"      \"Taió\",\r\n" + 
				"      \"Tangará\",\r\n" + 
				"      \"Tigrinhos\",\r\n" + 
				"      \"Tijucas\",\r\n" + 
				"      \"Timbé do Sul\",\r\n" + 
				"      \"Timbó\",\r\n" + 
				"      \"Timbó Grande\",\r\n" + 
				"      \"Três Barras\",\r\n" + 
				"      \"Treviso\",\r\n" + 
				"      \"Treze de Maio\",\r\n" + 
				"      \"Treze Tílias\",\r\n" + 
				"      \"Trombudo Central\",\r\n" + 
				"      \"Tubarão\",\r\n" + 
				"      \"Tunápolis\",\r\n" + 
				"      \"Turvo\",\r\n" + 
				"      \"União do Oeste\",\r\n" + 
				"      \"Urubici\",\r\n" + 
				"      \"Urupema\",\r\n" + 
				"      \"Urussanga\",\r\n" + 
				"      \"Vargeão\",\r\n" + 
				"      \"Vargem\",\r\n" + 
				"      \"Vargem Bonita\",\r\n" + 
				"      \"Vidal Ramos\",\r\n" + 
				"      \"Videira\",\r\n" + 
				"      \"Vitor Meireles\",\r\n" + 
				"      \"Witmarsum\",\r\n" + 
				"      \"Xanxerê\",\r\n" + 
				"      \"Xavantina\",\r\n" + 
				"      \"Xaxim\",\r\n" + 
				"      \"Zortéa\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"SE\",\r\n" + 
				"    \"nome\": \"Sergipe\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Amparo de São Francisco\",\r\n" + 
				"      \"Aquidabã\",\r\n" + 
				"      \"Aracaju\",\r\n" + 
				"      \"Arauá\",\r\n" + 
				"      \"Areia Branca\",\r\n" + 
				"      \"Barra dos Coqueiros\",\r\n" + 
				"      \"Boquim\",\r\n" + 
				"      \"Brejo Grande\",\r\n" + 
				"      \"Campo do Brito\",\r\n" + 
				"      \"Canhoba\",\r\n" + 
				"      \"Canindé de São Francisco\",\r\n" + 
				"      \"Capela\",\r\n" + 
				"      \"Carira\",\r\n" + 
				"      \"Carmópolis\",\r\n" + 
				"      \"Cedro de São João\",\r\n" + 
				"      \"Cristinápolis\",\r\n" + 
				"      \"Cumbe\",\r\n" + 
				"      \"Divina Pastora\",\r\n" + 
				"      \"Estância\",\r\n" + 
				"      \"Feira Nova\",\r\n" + 
				"      \"Frei Paulo\",\r\n" + 
				"      \"Gararu\",\r\n" + 
				"      \"General Maynard\",\r\n" + 
				"      \"Gracho Cardoso\",\r\n" + 
				"      \"Ilha das Flores\",\r\n" + 
				"      \"Indiaroba\",\r\n" + 
				"      \"Itabaiana\",\r\n" + 
				"      \"Itabaianinha\",\r\n" + 
				"      \"Itabi\",\r\n" + 
				"      \"Itaporanga d'Ajuda\",\r\n" + 
				"      \"Japaratuba\",\r\n" + 
				"      \"Japoatã\",\r\n" + 
				"      \"Lagarto\",\r\n" + 
				"      \"Laranjeiras\",\r\n" + 
				"      \"Macambira\",\r\n" + 
				"      \"Malhada dos Bois\",\r\n" + 
				"      \"Malhador\",\r\n" + 
				"      \"Maruim\",\r\n" + 
				"      \"Moita Bonita\",\r\n" + 
				"      \"Monte Alegre de Sergipe\",\r\n" + 
				"      \"Muribeca\",\r\n" + 
				"      \"Neópolis\",\r\n" + 
				"      \"Nossa Senhora Aparecida\",\r\n" + 
				"      \"Nossa Senhora da Glória\",\r\n" + 
				"      \"Nossa Senhora das Dores\",\r\n" + 
				"      \"Nossa Senhora de Lourdes\",\r\n" + 
				"      \"Nossa Senhora do Socorro\",\r\n" + 
				"      \"Pacatuba\",\r\n" + 
				"      \"Pedra Mole\",\r\n" + 
				"      \"Pedrinhas\",\r\n" + 
				"      \"Pinhão\",\r\n" + 
				"      \"Pirambu\",\r\n" + 
				"      \"Poço Redondo\",\r\n" + 
				"      \"Poço Verde\",\r\n" + 
				"      \"Porto da Folha\",\r\n" + 
				"      \"Propriá\",\r\n" + 
				"      \"Riachão do Dantas\",\r\n" + 
				"      \"Riachuelo\",\r\n" + 
				"      \"Ribeirópolis\",\r\n" + 
				"      \"Rosário do Catete\",\r\n" + 
				"      \"Salgado\",\r\n" + 
				"      \"Santa Luzia do Itanhy\",\r\n" + 
				"      \"Santa Rosa de Lima\",\r\n" + 
				"      \"Santana do São Francisco\",\r\n" + 
				"      \"Santo Amaro das Brotas\",\r\n" + 
				"      \"São Cristóvão\",\r\n" + 
				"      \"São Domingos\",\r\n" + 
				"      \"São Francisco\",\r\n" + 
				"      \"São Miguel do Aleixo\",\r\n" + 
				"      \"Simão Dias\",\r\n" + 
				"      \"Siriri\",\r\n" + 
				"      \"Telha\",\r\n" + 
				"      \"Tobias Barreto\",\r\n" + 
				"      \"Tomar do Geru\",\r\n" + 
				"      \"Umbaúba\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"SP\",\r\n" + 
				"    \"nome\": \"São Paulo\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Adamantina\",\r\n" + 
				"      \"Adolfo\",\r\n" + 
				"      \"Aguaí\",\r\n" + 
				"      \"Águas da Prata\",\r\n" + 
				"      \"Águas de Lindóia\",\r\n" + 
				"      \"Águas de Santa Bárbara\",\r\n" + 
				"      \"Águas de São Pedro\",\r\n" + 
				"      \"Agudos\",\r\n" + 
				"      \"Alambari\",\r\n" + 
				"      \"Alfredo Marcondes\",\r\n" + 
				"      \"Altair\",\r\n" + 
				"      \"Altinópolis\",\r\n" + 
				"      \"Alto Alegre\",\r\n" + 
				"      \"Alumínio\",\r\n" + 
				"      \"Álvares Florence\",\r\n" + 
				"      \"Álvares Machado\",\r\n" + 
				"      \"Álvaro de Carvalho\",\r\n" + 
				"      \"Alvinlândia\",\r\n" + 
				"      \"Americana\",\r\n" + 
				"      \"Américo Brasiliense\",\r\n" + 
				"      \"Américo de Campos\",\r\n" + 
				"      \"Amparo\",\r\n" + 
				"      \"Analândia\",\r\n" + 
				"      \"Andradina\",\r\n" + 
				"      \"Angatuba\",\r\n" + 
				"      \"Anhembi\",\r\n" + 
				"      \"Anhumas\",\r\n" + 
				"      \"Aparecida\",\r\n" + 
				"      \"Aparecida d'Oeste\",\r\n" + 
				"      \"Apiaí\",\r\n" + 
				"      \"Araçariguama\",\r\n" + 
				"      \"Araçatuba\",\r\n" + 
				"      \"Araçoiaba da Serra\",\r\n" + 
				"      \"Aramina\",\r\n" + 
				"      \"Arandu\",\r\n" + 
				"      \"Arapeí\",\r\n" + 
				"      \"Araraquara\",\r\n" + 
				"      \"Araras\",\r\n" + 
				"      \"Arco-Íris\",\r\n" + 
				"      \"Arealva\",\r\n" + 
				"      \"Areias\",\r\n" + 
				"      \"Areiópolis\",\r\n" + 
				"      \"Ariranha\",\r\n" + 
				"      \"Artur Nogueira\",\r\n" + 
				"      \"Arujá\",\r\n" + 
				"      \"Aspásia\",\r\n" + 
				"      \"Assis\",\r\n" + 
				"      \"Atibaia\",\r\n" + 
				"      \"Auriflama\",\r\n" + 
				"      \"Avaí\",\r\n" + 
				"      \"Avanhandava\",\r\n" + 
				"      \"Avaré\",\r\n" + 
				"      \"Bady Bassitt\",\r\n" + 
				"      \"Balbinos\",\r\n" + 
				"      \"Bálsamo\",\r\n" + 
				"      \"Bananal\",\r\n" + 
				"      \"Barão de Antonina\",\r\n" + 
				"      \"Barbosa\",\r\n" + 
				"      \"Bariri\",\r\n" + 
				"      \"Barra Bonita\",\r\n" + 
				"      \"Barra do Chapéu\",\r\n" + 
				"      \"Barra do Turvo\",\r\n" + 
				"      \"Barretos\",\r\n" + 
				"      \"Barrinha\",\r\n" + 
				"      \"Barueri\",\r\n" + 
				"      \"Bastos\",\r\n" + 
				"      \"Batatais\",\r\n" + 
				"      \"Bauru\",\r\n" + 
				"      \"Bebedouro\",\r\n" + 
				"      \"Bento de Abreu\",\r\n" + 
				"      \"Bernardino de Campos\",\r\n" + 
				"      \"Bertioga\",\r\n" + 
				"      \"Bilac\",\r\n" + 
				"      \"Birigui\",\r\n" + 
				"      \"Biritiba-Mirim\",\r\n" + 
				"      \"Boa Esperança do Sul\",\r\n" + 
				"      \"Bocaina\",\r\n" + 
				"      \"Bofete\",\r\n" + 
				"      \"Boituva\",\r\n" + 
				"      \"Bom Jesus dos Perdões\",\r\n" + 
				"      \"Bom Sucesso de Itararé\",\r\n" + 
				"      \"Borá\",\r\n" + 
				"      \"Boracéia\",\r\n" + 
				"      \"Borborema\",\r\n" + 
				"      \"Borebi\",\r\n" + 
				"      \"Botucatu\",\r\n" + 
				"      \"Bragança Paulista\",\r\n" + 
				"      \"Braúna\",\r\n" + 
				"      \"Brejo Alegre\",\r\n" + 
				"      \"Brodowski\",\r\n" + 
				"      \"Brotas\",\r\n" + 
				"      \"Buri\",\r\n" + 
				"      \"Buritama\",\r\n" + 
				"      \"Buritizal\",\r\n" + 
				"      \"Cabrália Paulista\",\r\n" + 
				"      \"Cabreúva\",\r\n" + 
				"      \"Caçapava\",\r\n" + 
				"      \"Cachoeira Paulista\",\r\n" + 
				"      \"Caconde\",\r\n" + 
				"      \"Cafelândia\",\r\n" + 
				"      \"Caiabu\",\r\n" + 
				"      \"Caieiras\",\r\n" + 
				"      \"Caiuá\",\r\n" + 
				"      \"Cajamar\",\r\n" + 
				"      \"Cajati\",\r\n" + 
				"      \"Cajobi\",\r\n" + 
				"      \"Cajuru\",\r\n" + 
				"      \"Campina do Monte Alegre\",\r\n" + 
				"      \"Campinas\",\r\n" + 
				"      \"Campo Limpo Paulista\",\r\n" + 
				"      \"Campos do Jordão\",\r\n" + 
				"      \"Campos Novos Paulista\",\r\n" + 
				"      \"Cananéia\",\r\n" + 
				"      \"Canas\",\r\n" + 
				"      \"Cândido Mota\",\r\n" + 
				"      \"Cândido Rodrigues\",\r\n" + 
				"      \"Canitar\",\r\n" + 
				"      \"Capão Bonito\",\r\n" + 
				"      \"Capela do Alto\",\r\n" + 
				"      \"Capivari\",\r\n" + 
				"      \"Caraguatatuba\",\r\n" + 
				"      \"Carapicuíba\",\r\n" + 
				"      \"Cardoso\",\r\n" + 
				"      \"Casa Branca\",\r\n" + 
				"      \"Cássia dos Coqueiros\",\r\n" + 
				"      \"Castilho\",\r\n" + 
				"      \"Catanduva\",\r\n" + 
				"      \"Catiguá\",\r\n" + 
				"      \"Cedral\",\r\n" + 
				"      \"Cerqueira César\",\r\n" + 
				"      \"Cerquilho\",\r\n" + 
				"      \"Cesário Lange\",\r\n" + 
				"      \"Charqueada\",\r\n" + 
				"      \"Chavantes\",\r\n" + 
				"      \"Clementina\",\r\n" + 
				"      \"Colina\",\r\n" + 
				"      \"Colômbia\",\r\n" + 
				"      \"Conchal\",\r\n" + 
				"      \"Conchas\",\r\n" + 
				"      \"Cordeirópolis\",\r\n" + 
				"      \"Coroados\",\r\n" + 
				"      \"Coronel Macedo\",\r\n" + 
				"      \"Corumbataí\",\r\n" + 
				"      \"Cosmópolis\",\r\n" + 
				"      \"Cosmorama\",\r\n" + 
				"      \"Cotia\",\r\n" + 
				"      \"Cravinhos\",\r\n" + 
				"      \"Cristais Paulista\",\r\n" + 
				"      \"Cruzália\",\r\n" + 
				"      \"Cruzeiro\",\r\n" + 
				"      \"Cubatão\",\r\n" + 
				"      \"Cunha\",\r\n" + 
				"      \"Descalvado\",\r\n" + 
				"      \"Diadema\",\r\n" + 
				"      \"Dirce Reis\",\r\n" + 
				"      \"Divinolândia\",\r\n" + 
				"      \"Dobrada\",\r\n" + 
				"      \"Dois Córregos\",\r\n" + 
				"      \"Dolcinópolis\",\r\n" + 
				"      \"Dourado\",\r\n" + 
				"      \"Dracena\",\r\n" + 
				"      \"Duartina\",\r\n" + 
				"      \"Dumont\",\r\n" + 
				"      \"Echaporã\",\r\n" + 
				"      \"Eldorado\",\r\n" + 
				"      \"Elias Fausto\",\r\n" + 
				"      \"Elisiário\",\r\n" + 
				"      \"Embaúba\",\r\n" + 
				"      \"Embu\",\r\n" + 
				"      \"Embu-Guaçu\",\r\n" + 
				"      \"Emilianópolis\",\r\n" + 
				"      \"Engenheiro Coelho\",\r\n" + 
				"      \"Espírito Santo do Pinhal\",\r\n" + 
				"      \"Espírito Santo do Turvo\",\r\n" + 
				"      \"Estiva Gerbi\",\r\n" + 
				"      \"Estrela d'Oeste\",\r\n" + 
				"      \"Estrela do Norte\",\r\n" + 
				"      \"Euclides da Cunha Paulista\",\r\n" + 
				"      \"Fartura\",\r\n" + 
				"      \"Fernando Prestes\",\r\n" + 
				"      \"Fernandópolis\",\r\n" + 
				"      \"Fernão\",\r\n" + 
				"      \"Ferraz de Vasconcelos\",\r\n" + 
				"      \"Flora Rica\",\r\n" + 
				"      \"Floreal\",\r\n" + 
				"      \"Florínia\",\r\n" + 
				"      \"Flórida Paulista\",\r\n" + 
				"      \"Franca\",\r\n" + 
				"      \"Francisco Morato\",\r\n" + 
				"      \"Franco da Rocha\",\r\n" + 
				"      \"Gabriel Monteiro\",\r\n" + 
				"      \"Gália\",\r\n" + 
				"      \"Garça\",\r\n" + 
				"      \"Gastão Vidigal\",\r\n" + 
				"      \"Gavião Peixoto\",\r\n" + 
				"      \"General Salgado\",\r\n" + 
				"      \"Getulina\",\r\n" + 
				"      \"Glicério\",\r\n" + 
				"      \"Guaiçara\",\r\n" + 
				"      \"Guaimbê\",\r\n" + 
				"      \"Guaíra\",\r\n" + 
				"      \"Guapiaçu\",\r\n" + 
				"      \"Guapiara\",\r\n" + 
				"      \"Guará\",\r\n" + 
				"      \"Guaraçaí\",\r\n" + 
				"      \"Guaraci\",\r\n" + 
				"      \"Guarani d'Oeste\",\r\n" + 
				"      \"Guarantã\",\r\n" + 
				"      \"Guararapes\",\r\n" + 
				"      \"Guararema\",\r\n" + 
				"      \"Guaratinguetá\",\r\n" + 
				"      \"Guareí\",\r\n" + 
				"      \"Guariba\",\r\n" + 
				"      \"Guarujá\",\r\n" + 
				"      \"Guarulhos\",\r\n" + 
				"      \"Guatapará\",\r\n" + 
				"      \"Guzolândia\",\r\n" + 
				"      \"Herculândia\",\r\n" + 
				"      \"Holambra\",\r\n" + 
				"      \"Hortolândia\",\r\n" + 
				"      \"Iacanga\",\r\n" + 
				"      \"Iacri\",\r\n" + 
				"      \"Iaras\",\r\n" + 
				"      \"Ibaté\",\r\n" + 
				"      \"Ibirá\",\r\n" + 
				"      \"Ibirarema\",\r\n" + 
				"      \"Ibitinga\",\r\n" + 
				"      \"Ibiúna\",\r\n" + 
				"      \"Icém\",\r\n" + 
				"      \"Iepê\",\r\n" + 
				"      \"Igaraçu do Tietê\",\r\n" + 
				"      \"Igarapava\",\r\n" + 
				"      \"Igaratá\",\r\n" + 
				"      \"Iguape\",\r\n" + 
				"      \"Ilha Comprida\",\r\n" + 
				"      \"Ilha Solteira\",\r\n" + 
				"      \"Ilhabela\",\r\n" + 
				"      \"Indaiatuba\",\r\n" + 
				"      \"Indiana\",\r\n" + 
				"      \"Indiaporã\",\r\n" + 
				"      \"Inúbia Paulista\",\r\n" + 
				"      \"Ipauçu\",\r\n" + 
				"      \"Iperó\",\r\n" + 
				"      \"Ipeúna\",\r\n" + 
				"      \"Ipiguá\",\r\n" + 
				"      \"Iporanga\",\r\n" + 
				"      \"Ipuã\",\r\n" + 
				"      \"Iracemápolis\",\r\n" + 
				"      \"Irapuã\",\r\n" + 
				"      \"Irapuru\",\r\n" + 
				"      \"Itaberá\",\r\n" + 
				"      \"Itaí\",\r\n" + 
				"      \"Itajobi\",\r\n" + 
				"      \"Itaju\",\r\n" + 
				"      \"Itanhaém\",\r\n" + 
				"      \"Itaóca\",\r\n" + 
				"      \"Itapecerica da Serra\",\r\n" + 
				"      \"Itapetininga\",\r\n" + 
				"      \"Itapeva\",\r\n" + 
				"      \"Itapevi\",\r\n" + 
				"      \"Itapira\",\r\n" + 
				"      \"Itapirapuã Paulista\",\r\n" + 
				"      \"Itápolis\",\r\n" + 
				"      \"Itaporanga\",\r\n" + 
				"      \"Itapuí\",\r\n" + 
				"      \"Itapura\",\r\n" + 
				"      \"Itaquaquecetuba\",\r\n" + 
				"      \"Itararé\",\r\n" + 
				"      \"Itariri\",\r\n" + 
				"      \"Itatiba\",\r\n" + 
				"      \"Itatinga\",\r\n" + 
				"      \"Itirapina\",\r\n" + 
				"      \"Itirapuã\",\r\n" + 
				"      \"Itobi\",\r\n" + 
				"      \"Itu\",\r\n" + 
				"      \"Itupeva\",\r\n" + 
				"      \"Ituverava\",\r\n" + 
				"      \"Jaborandi\",\r\n" + 
				"      \"Jaboticabal\",\r\n" + 
				"      \"Jacareí\",\r\n" + 
				"      \"Jaci\",\r\n" + 
				"      \"Jacupiranga\",\r\n" + 
				"      \"Jaguariúna\",\r\n" + 
				"      \"Jales\",\r\n" + 
				"      \"Jambeiro\",\r\n" + 
				"      \"Jandira\",\r\n" + 
				"      \"Jardinópolis\",\r\n" + 
				"      \"Jarinu\",\r\n" + 
				"      \"Jaú\",\r\n" + 
				"      \"Jeriquara\",\r\n" + 
				"      \"Joanópolis\",\r\n" + 
				"      \"João Ramalho\",\r\n" + 
				"      \"José Bonifácio\",\r\n" + 
				"      \"Júlio Mesquita\",\r\n" + 
				"      \"Jumirim\",\r\n" + 
				"      \"Jundiaí\",\r\n" + 
				"      \"Junqueirópolis\",\r\n" + 
				"      \"Juquiá\",\r\n" + 
				"      \"Juquitiba\",\r\n" + 
				"      \"Lagoinha\",\r\n" + 
				"      \"Laranjal Paulista\",\r\n" + 
				"      \"Lavínia\",\r\n" + 
				"      \"Lavrinhas\",\r\n" + 
				"      \"Leme\",\r\n" + 
				"      \"Lençóis Paulista\",\r\n" + 
				"      \"Limeira\",\r\n" + 
				"      \"Lindóia\",\r\n" + 
				"      \"Lins\",\r\n" + 
				"      \"Lorena\",\r\n" + 
				"      \"Lourdes\",\r\n" + 
				"      \"Louveira\",\r\n" + 
				"      \"Lucélia\",\r\n" + 
				"      \"Lucianópolis\",\r\n" + 
				"      \"Luís Antônio\",\r\n" + 
				"      \"Luiziânia\",\r\n" + 
				"      \"Lupércio\",\r\n" + 
				"      \"Lutécia\",\r\n" + 
				"      \"Macatuba\",\r\n" + 
				"      \"Macaubal\",\r\n" + 
				"      \"Macedônia\",\r\n" + 
				"      \"Magda\",\r\n" + 
				"      \"Mairinque\",\r\n" + 
				"      \"Mairiporã\",\r\n" + 
				"      \"Manduri\",\r\n" + 
				"      \"Marabá Paulista\",\r\n" + 
				"      \"Maracaí\",\r\n" + 
				"      \"Marapoama\",\r\n" + 
				"      \"Mariápolis\",\r\n" + 
				"      \"Marília\",\r\n" + 
				"      \"Marinópolis\",\r\n" + 
				"      \"Martinópolis\",\r\n" + 
				"      \"Matão\",\r\n" + 
				"      \"Mauá\",\r\n" + 
				"      \"Mendonça\",\r\n" + 
				"      \"Meridiano\",\r\n" + 
				"      \"Mesópolis\",\r\n" + 
				"      \"Miguelópolis\",\r\n" + 
				"      \"Mineiros do Tietê\",\r\n" + 
				"      \"Mira Estrela\",\r\n" + 
				"      \"Miracatu\",\r\n" + 
				"      \"Mirandópolis\",\r\n" + 
				"      \"Mirante do Paranapanema\",\r\n" + 
				"      \"Mirassol\",\r\n" + 
				"      \"Mirassolândia\",\r\n" + 
				"      \"Mococa\",\r\n" + 
				"      \"Mogi das Cruzes\",\r\n" + 
				"      \"Mogi-Guaçu\",\r\n" + 
				"      \"Mogi-Mirim\",\r\n" + 
				"      \"Mombuca\",\r\n" + 
				"      \"Monções\",\r\n" + 
				"      \"Mongaguá\",\r\n" + 
				"      \"Monte Alegre do Sul\",\r\n" + 
				"      \"Monte Alto\",\r\n" + 
				"      \"Monte Aprazível\",\r\n" + 
				"      \"Monte Azul Paulista\",\r\n" + 
				"      \"Monte Castelo\",\r\n" + 
				"      \"Monte Mor\",\r\n" + 
				"      \"Monteiro Lobato\",\r\n" + 
				"      \"Morro Agudo\",\r\n" + 
				"      \"Morungaba\",\r\n" + 
				"      \"Motuca\",\r\n" + 
				"      \"Murutinga do Sul\",\r\n" + 
				"      \"Nantes\",\r\n" + 
				"      \"Narandiba\",\r\n" + 
				"      \"Natividade da Serra\",\r\n" + 
				"      \"Nazaré Paulista\",\r\n" + 
				"      \"Neves Paulista\",\r\n" + 
				"      \"Nhandeara\",\r\n" + 
				"      \"Nipoã\",\r\n" + 
				"      \"Nova Aliança\",\r\n" + 
				"      \"Nova Campina\",\r\n" + 
				"      \"Nova Canaã Paulista\",\r\n" + 
				"      \"Nova Castilho\",\r\n" + 
				"      \"Nova Europa\",\r\n" + 
				"      \"Nova Granada\",\r\n" + 
				"      \"Nova Guataporanga\",\r\n" + 
				"      \"Nova Independência\",\r\n" + 
				"      \"Nova Luzitânia\",\r\n" + 
				"      \"Nova Odessa\",\r\n" + 
				"      \"Novais\",\r\n" + 
				"      \"Novo Horizonte\",\r\n" + 
				"      \"Nuporanga\",\r\n" + 
				"      \"Ocauçu\",\r\n" + 
				"      \"Óleo\",\r\n" + 
				"      \"Olímpia\",\r\n" + 
				"      \"Onda Verde\",\r\n" + 
				"      \"Oriente\",\r\n" + 
				"      \"Orindiúva\",\r\n" + 
				"      \"Orlândia\",\r\n" + 
				"      \"Osasco\",\r\n" + 
				"      \"Oscar Bressane\",\r\n" + 
				"      \"Osvaldo Cruz\",\r\n" + 
				"      \"Ourinhos\",\r\n" + 
				"      \"Ouro Verde\",\r\n" + 
				"      \"Ouroeste\",\r\n" + 
				"      \"Pacaembu\",\r\n" + 
				"      \"Palestina\",\r\n" + 
				"      \"Palmares Paulista\",\r\n" + 
				"      \"Palmeira d'Oeste\",\r\n" + 
				"      \"Palmital\",\r\n" + 
				"      \"Panorama\",\r\n" + 
				"      \"Paraguaçu Paulista\",\r\n" + 
				"      \"Paraibuna\",\r\n" + 
				"      \"Paraíso\",\r\n" + 
				"      \"Paranapanema\",\r\n" + 
				"      \"Paranapuã\",\r\n" + 
				"      \"Parapuã\",\r\n" + 
				"      \"Pardinho\",\r\n" + 
				"      \"Pariquera-Açu\",\r\n" + 
				"      \"Parisi\",\r\n" + 
				"      \"Patrocínio Paulista\",\r\n" + 
				"      \"Paulicéia\",\r\n" + 
				"      \"Paulínia\",\r\n" + 
				"      \"Paulistânia\",\r\n" + 
				"      \"Paulo de Faria\",\r\n" + 
				"      \"Pederneiras\",\r\n" + 
				"      \"Pedra Bela\",\r\n" + 
				"      \"Pedranópolis\",\r\n" + 
				"      \"Pedregulho\",\r\n" + 
				"      \"Pedreira\",\r\n" + 
				"      \"Pedrinhas Paulista\",\r\n" + 
				"      \"Pedro de Toledo\",\r\n" + 
				"      \"Penápolis\",\r\n" + 
				"      \"Pereira Barreto\",\r\n" + 
				"      \"Pereiras\",\r\n" + 
				"      \"Peruíbe\",\r\n" + 
				"      \"Piacatu\",\r\n" + 
				"      \"Piedade\",\r\n" + 
				"      \"Pilar do Sul\",\r\n" + 
				"      \"Pindamonhangaba\",\r\n" + 
				"      \"Pindorama\",\r\n" + 
				"      \"Pinhalzinho\",\r\n" + 
				"      \"Piquerobi\",\r\n" + 
				"      \"Piquete\",\r\n" + 
				"      \"Piracaia\",\r\n" + 
				"      \"Piracicaba\",\r\n" + 
				"      \"Piraju\",\r\n" + 
				"      \"Pirajuí\",\r\n" + 
				"      \"Pirangi\",\r\n" + 
				"      \"Pirapora do Bom Jesus\",\r\n" + 
				"      \"Pirapozinho\",\r\n" + 
				"      \"Pirassununga\",\r\n" + 
				"      \"Piratininga\",\r\n" + 
				"      \"Pitangueiras\",\r\n" + 
				"      \"Planalto\",\r\n" + 
				"      \"Platina\",\r\n" + 
				"      \"Poá\",\r\n" + 
				"      \"Poloni\",\r\n" + 
				"      \"Pompéia\",\r\n" + 
				"      \"Pongaí\",\r\n" + 
				"      \"Pontal\",\r\n" + 
				"      \"Pontalinda\",\r\n" + 
				"      \"Pontes Gestal\",\r\n" + 
				"      \"Populina\",\r\n" + 
				"      \"Porangaba\",\r\n" + 
				"      \"Porto Feliz\",\r\n" + 
				"      \"Porto Ferreira\",\r\n" + 
				"      \"Potim\",\r\n" + 
				"      \"Potirendaba\",\r\n" + 
				"      \"Pracinha\",\r\n" + 
				"      \"Pradópolis\",\r\n" + 
				"      \"Praia Grande\",\r\n" + 
				"      \"Pratânia\",\r\n" + 
				"      \"Presidente Alves\",\r\n" + 
				"      \"Presidente Bernardes\",\r\n" + 
				"      \"Presidente Epitácio\",\r\n" + 
				"      \"Presidente Prudente\",\r\n" + 
				"      \"Presidente Venceslau\",\r\n" + 
				"      \"Promissão\",\r\n" + 
				"      \"Quadra\",\r\n" + 
				"      \"Quatá\",\r\n" + 
				"      \"Queiroz\",\r\n" + 
				"      \"Queluz\",\r\n" + 
				"      \"Quintana\",\r\n" + 
				"      \"Rafard\",\r\n" + 
				"      \"Rancharia\",\r\n" + 
				"      \"Redenção da Serra\",\r\n" + 
				"      \"Regente Feijó\",\r\n" + 
				"      \"Reginópolis\",\r\n" + 
				"      \"Registro\",\r\n" + 
				"      \"Restinga\",\r\n" + 
				"      \"Ribeira\",\r\n" + 
				"      \"Ribeirão Bonito\",\r\n" + 
				"      \"Ribeirão Branco\",\r\n" + 
				"      \"Ribeirão Corrente\",\r\n" + 
				"      \"Ribeirão do Sul\",\r\n" + 
				"      \"Ribeirão dos Índios\",\r\n" + 
				"      \"Ribeirão Grande\",\r\n" + 
				"      \"Ribeirão Pires\",\r\n" + 
				"      \"Ribeirão Preto\",\r\n" + 
				"      \"Rifaina\",\r\n" + 
				"      \"Rincão\",\r\n" + 
				"      \"Rinópolis\",\r\n" + 
				"      \"Rio Claro\",\r\n" + 
				"      \"Rio das Pedras\",\r\n" + 
				"      \"Rio Grande da Serra\",\r\n" + 
				"      \"Riolândia\",\r\n" + 
				"      \"Riversul\",\r\n" + 
				"      \"Rosana\",\r\n" + 
				"      \"Roseira\",\r\n" + 
				"      \"Rubiácea\",\r\n" + 
				"      \"Rubinéia\",\r\n" + 
				"      \"Sabino\",\r\n" + 
				"      \"Sagres\",\r\n" + 
				"      \"Sales\",\r\n" + 
				"      \"Sales Oliveira\",\r\n" + 
				"      \"Salesópolis\",\r\n" + 
				"      \"Salmourão\",\r\n" + 
				"      \"Saltinho\",\r\n" + 
				"      \"Salto\",\r\n" + 
				"      \"Salto de Pirapora\",\r\n" + 
				"      \"Salto Grande\",\r\n" + 
				"      \"Sandovalina\",\r\n" + 
				"      \"Santa Adélia\",\r\n" + 
				"      \"Santa Albertina\",\r\n" + 
				"      \"Santa Bárbara d'Oeste\",\r\n" + 
				"      \"Santa Branca\",\r\n" + 
				"      \"Santa Clara d'Oeste\",\r\n" + 
				"      \"Santa Cruz da Conceição\",\r\n" + 
				"      \"Santa Cruz da Esperança\",\r\n" + 
				"      \"Santa Cruz das Palmeiras\",\r\n" + 
				"      \"Santa Cruz do Rio Pardo\",\r\n" + 
				"      \"Santa Ernestina\",\r\n" + 
				"      \"Santa Fé do Sul\",\r\n" + 
				"      \"Santa Gertrudes\",\r\n" + 
				"      \"Santa Isabel\",\r\n" + 
				"      \"Santa Lúcia\",\r\n" + 
				"      \"Santa Maria da Serra\",\r\n" + 
				"      \"Santa Mercedes\",\r\n" + 
				"      \"Santa Rita d'Oeste\",\r\n" + 
				"      \"Santa Rita do Passa Quatro\",\r\n" + 
				"      \"Santa Rosa de Viterbo\",\r\n" + 
				"      \"Santa Salete\",\r\n" + 
				"      \"Santana da Ponte Pensa\",\r\n" + 
				"      \"Santana de Parnaíba\",\r\n" + 
				"      \"Santo Anastácio\",\r\n" + 
				"      \"Santo André\",\r\n" + 
				"      \"Santo Antônio da Alegria\",\r\n" + 
				"      \"Santo Antônio de Posse\",\r\n" + 
				"      \"Santo Antônio do Aracanguá\",\r\n" + 
				"      \"Santo Antônio do Jardim\",\r\n" + 
				"      \"Santo Antônio do Pinhal\",\r\n" + 
				"      \"Santo Expedito\",\r\n" + 
				"      \"Santópolis do Aguapeí\",\r\n" + 
				"      \"Santos\",\r\n" + 
				"      \"São Bento do Sapucaí\",\r\n" + 
				"      \"São Bernardo do Campo\",\r\n" + 
				"      \"São Caetano do Sul\",\r\n" + 
				"      \"São Carlos\",\r\n" + 
				"      \"São Francisco\",\r\n" + 
				"      \"São João da Boa Vista\",\r\n" + 
				"      \"São João das Duas Pontes\",\r\n" + 
				"      \"São João de Iracema\",\r\n" + 
				"      \"São João do Pau d'Alho\",\r\n" + 
				"      \"São Joaquim da Barra\",\r\n" + 
				"      \"São José da Bela Vista\",\r\n" + 
				"      \"São José do Barreiro\",\r\n" + 
				"      \"São José do Rio Pardo\",\r\n" + 
				"      \"São José do Rio Preto\",\r\n" + 
				"      \"São José dos Campos\",\r\n" + 
				"      \"São Lourenço da Serra\",\r\n" + 
				"      \"São Luís do Paraitinga\",\r\n" + 
				"      \"São Manuel\",\r\n" + 
				"      \"São Miguel Arcanjo\",\r\n" + 
				"      \"São Paulo\",\r\n" + 
				"      \"São Pedro\",\r\n" + 
				"      \"São Pedro do Turvo\",\r\n" + 
				"      \"São Roque\",\r\n" + 
				"      \"São Sebastião\",\r\n" + 
				"      \"São Sebastião da Grama\",\r\n" + 
				"      \"São Simão\",\r\n" + 
				"      \"São Vicente\",\r\n" + 
				"      \"Sarapuí\",\r\n" + 
				"      \"Sarutaiá\",\r\n" + 
				"      \"Sebastianópolis do Sul\",\r\n" + 
				"      \"Serra Azul\",\r\n" + 
				"      \"Serra Negra\",\r\n" + 
				"      \"Serrana\",\r\n" + 
				"      \"Sertãozinho\",\r\n" + 
				"      \"Sete Barras\",\r\n" + 
				"      \"Severínia\",\r\n" + 
				"      \"Silveiras\",\r\n" + 
				"      \"Socorro\",\r\n" + 
				"      \"Sorocaba\",\r\n" + 
				"      \"Sud Mennucci\",\r\n" + 
				"      \"Sumaré\",\r\n" + 
				"      \"Suzanápolis\",\r\n" + 
				"      \"Suzano\",\r\n" + 
				"      \"Tabapuã\",\r\n" + 
				"      \"Tabatinga\",\r\n" + 
				"      \"Taboão da Serra\",\r\n" + 
				"      \"Taciba\",\r\n" + 
				"      \"Taguaí\",\r\n" + 
				"      \"Taiaçu\",\r\n" + 
				"      \"Taiúva\",\r\n" + 
				"      \"Tambaú\",\r\n" + 
				"      \"Tanabi\",\r\n" + 
				"      \"Tapiraí\",\r\n" + 
				"      \"Tapiratiba\",\r\n" + 
				"      \"Taquaral\",\r\n" + 
				"      \"Taquaritinga\",\r\n" + 
				"      \"Taquarituba\",\r\n" + 
				"      \"Taquarivaí\",\r\n" + 
				"      \"Tarabai\",\r\n" + 
				"      \"Tarumã\",\r\n" + 
				"      \"Tatuí\",\r\n" + 
				"      \"Taubaté\",\r\n" + 
				"      \"Tejupá\",\r\n" + 
				"      \"Teodoro Sampaio\",\r\n" + 
				"      \"Terra Roxa\",\r\n" + 
				"      \"Tietê\",\r\n" + 
				"      \"Timburi\",\r\n" + 
				"      \"Torre de Pedra\",\r\n" + 
				"      \"Torrinha\",\r\n" + 
				"      \"Trabiju\",\r\n" + 
				"      \"Tremembé\",\r\n" + 
				"      \"Três Fronteiras\",\r\n" + 
				"      \"Tuiuti\",\r\n" + 
				"      \"Tupã\",\r\n" + 
				"      \"Tupi Paulista\",\r\n" + 
				"      \"Turiúba\",\r\n" + 
				"      \"Turmalina\",\r\n" + 
				"      \"Ubarana\",\r\n" + 
				"      \"Ubatuba\",\r\n" + 
				"      \"Ubirajara\",\r\n" + 
				"      \"Uchoa\",\r\n" + 
				"      \"União Paulista\",\r\n" + 
				"      \"Urânia\",\r\n" + 
				"      \"Uru\",\r\n" + 
				"      \"Urupês\",\r\n" + 
				"      \"Valentim Gentil\",\r\n" + 
				"      \"Valinhos\",\r\n" + 
				"      \"Valparaíso\",\r\n" + 
				"      \"Vargem\",\r\n" + 
				"      \"Vargem Grande do Sul\",\r\n" + 
				"      \"Vargem Grande Paulista\",\r\n" + 
				"      \"Várzea Paulista\",\r\n" + 
				"      \"Vera Cruz\",\r\n" + 
				"      \"Vinhedo\",\r\n" + 
				"      \"Viradouro\",\r\n" + 
				"      \"Vista Alegre do Alto\",\r\n" + 
				"      \"Vitória Brasil\",\r\n" + 
				"      \"Votorantim\",\r\n" + 
				"      \"Votuporanga\",\r\n" + 
				"      \"Zacarias\"\r\n" + 
				"    ]\r\n" + 
				"  }, {\r\n" + 
				"    \"sigla\": \"TO\",\r\n" + 
				"    \"nome\": \"Tocantins\",\r\n" + 
				"    \"cidades\": [\r\n" + 
				"      \"Abreulândia\",\r\n" + 
				"      \"Aguiarnópolis\",\r\n" + 
				"      \"Aliança do Tocantins\",\r\n" + 
				"      \"Almas\",\r\n" + 
				"      \"Alvorada\",\r\n" + 
				"      \"Ananás\",\r\n" + 
				"      \"Angico\",\r\n" + 
				"      \"Aparecida do Rio Negro\",\r\n" + 
				"      \"Aragominas\",\r\n" + 
				"      \"Araguacema\",\r\n" + 
				"      \"Araguaçu\",\r\n" + 
				"      \"Araguaína\",\r\n" + 
				"      \"Araguanã\",\r\n" + 
				"      \"Araguatins\",\r\n" + 
				"      \"Arapoema\",\r\n" + 
				"      \"Arraias\",\r\n" + 
				"      \"Augustinópolis\",\r\n" + 
				"      \"Aurora do Tocantins\",\r\n" + 
				"      \"Axixá do Tocantins\",\r\n" + 
				"      \"Babaçulândia\",\r\n" + 
				"      \"Bandeirantes do Tocantins\",\r\n" + 
				"      \"Barra do Ouro\",\r\n" + 
				"      \"Barrolândia\",\r\n" + 
				"      \"Bernardo Sayão\",\r\n" + 
				"      \"Bom Jesus do Tocantins\",\r\n" + 
				"      \"Brasilândia do Tocantins\",\r\n" + 
				"      \"Brejinho de Nazaré\",\r\n" + 
				"      \"Buriti do Tocantins\",\r\n" + 
				"      \"Cachoeirinha\",\r\n" + 
				"      \"Campos Lindos\",\r\n" + 
				"      \"Cariri do Tocantins\",\r\n" + 
				"      \"Carmolândia\",\r\n" + 
				"      \"Carrasco Bonito\",\r\n" + 
				"      \"Caseara\",\r\n" + 
				"      \"Centenário\",\r\n" + 
				"      \"Chapada da Natividade\",\r\n" + 
				"      \"Chapada de Areia\",\r\n" + 
				"      \"Colinas do Tocantins\",\r\n" + 
				"      \"Colméia\",\r\n" + 
				"      \"Combinado\",\r\n" + 
				"      \"Conceição do Tocantins\",\r\n" + 
				"      \"Couto de Magalhães\",\r\n" + 
				"      \"Cristalândia\",\r\n" + 
				"      \"Crixás do Tocantins\",\r\n" + 
				"      \"Darcinópolis\",\r\n" + 
				"      \"Dianópolis\",\r\n" + 
				"      \"Divinópolis do Tocantins\",\r\n" + 
				"      \"Dois Irmãos do Tocantins\",\r\n" + 
				"      \"Dueré\",\r\n" + 
				"      \"Esperantina\",\r\n" + 
				"      \"Fátima\",\r\n" + 
				"      \"Figueirópolis\",\r\n" + 
				"      \"Filadélfia\",\r\n" + 
				"      \"Formoso do Araguaia\",\r\n" + 
				"      \"Fortaleza do Tabocão\",\r\n" + 
				"      \"Goianorte\",\r\n" + 
				"      \"Goiatins\",\r\n" + 
				"      \"Guaraí\",\r\n" + 
				"      \"Gurupi\",\r\n" + 
				"      \"Ipueiras\",\r\n" + 
				"      \"Itacajá\",\r\n" + 
				"      \"Itaguatins\",\r\n" + 
				"      \"Itapiratins\",\r\n" + 
				"      \"Itaporã do Tocantins\",\r\n" + 
				"      \"Jaú do Tocantins\",\r\n" + 
				"      \"Juarina\",\r\n" + 
				"      \"Lagoa da Confusão\",\r\n" + 
				"      \"Lagoa do Tocantins\",\r\n" + 
				"      \"Lajeado\",\r\n" + 
				"      \"Lavandeira\",\r\n" + 
				"      \"Lizarda\",\r\n" + 
				"      \"Luzinópolis\",\r\n" + 
				"      \"Marianópolis do Tocantins\",\r\n" + 
				"      \"Mateiros\",\r\n" + 
				"      \"Maurilândia do Tocantins\",\r\n" + 
				"      \"Miracema do Tocantins\",\r\n" + 
				"      \"Miranorte\",\r\n" + 
				"      \"Monte do Carmo\",\r\n" + 
				"      \"Monte Santo do Tocantins\",\r\n" + 
				"      \"Muricilândia\",\r\n" + 
				"      \"Natividade\",\r\n" + 
				"      \"Nazaré\",\r\n" + 
				"      \"Nova Olinda\",\r\n" + 
				"      \"Nova Rosalândia\",\r\n" + 
				"      \"Novo Acordo\",\r\n" + 
				"      \"Novo Alegre\",\r\n" + 
				"      \"Novo Jardim\",\r\n" + 
				"      \"Oliveira de Fátima\",\r\n" + 
				"      \"Palmas\",\r\n" + 
				"      \"Palmeirante\",\r\n" + 
				"      \"Palmeiras do Tocantins\",\r\n" + 
				"      \"Palmeirópolis\",\r\n" + 
				"      \"Paraíso do Tocantins\",\r\n" + 
				"      \"Paranã\",\r\n" + 
				"      \"Pau d'Arco\",\r\n" + 
				"      \"Pedro Afonso\",\r\n" + 
				"      \"Peixe\",\r\n" + 
				"      \"Pequizeiro\",\r\n" + 
				"      \"Pindorama do Tocantins\",\r\n" + 
				"      \"Piraquê\",\r\n" + 
				"      \"Pium\",\r\n" + 
				"      \"Ponte Alta do Bom Jesus\",\r\n" + 
				"      \"Ponte Alta do Tocantins\",\r\n" + 
				"      \"Porto Alegre do Tocantins\",\r\n" + 
				"      \"Porto Nacional\",\r\n" + 
				"      \"Praia Norte\",\r\n" + 
				"      \"Presidente Kennedy\",\r\n" + 
				"      \"Pugmil\",\r\n" + 
				"      \"Recursolândia\",\r\n" + 
				"      \"Riachinho\",\r\n" + 
				"      \"Rio da Conceição\",\r\n" + 
				"      \"Rio dos Bois\",\r\n" + 
				"      \"Rio Sono\",\r\n" + 
				"      \"Sampaio\",\r\n" + 
				"      \"Sandolândia\",\r\n" + 
				"      \"Santa Fé do Araguaia\",\r\n" + 
				"      \"Santa Maria do Tocantins\",\r\n" + 
				"      \"Santa Rita do Tocantins\",\r\n" + 
				"      \"Santa Rosa do Tocantins\",\r\n" + 
				"      \"Santa Tereza do Tocantins\",\r\n" + 
				"      \"Santa Terezinha Tocantins\",\r\n" + 
				"      \"São Bento do Tocantins\",\r\n" + 
				"      \"São Félix do Tocantins\",\r\n" + 
				"      \"São Miguel do Tocantins\",\r\n" + 
				"      \"São Salvador do Tocantins\",\r\n" + 
				"      \"São Sebastião do Tocantins\",\r\n" + 
				"      \"São Valério da Natividade\",\r\n" + 
				"      \"Silvanópolis\",\r\n" + 
				"      \"Sítio Novo do Tocantins\",\r\n" + 
				"      \"Sucupira\",\r\n" + 
				"      \"Taguatinga\",\r\n" + 
				"      \"Taipas do Tocantins\",\r\n" + 
				"      \"Talismã\",\r\n" + 
				"      \"Tocantínia\",\r\n" + 
				"      \"Tocantinópolis\",\r\n" + 
				"      \"Tupirama\",\r\n" + 
				"      \"Tupiratins\",\r\n" + 
				"      \"Wanderlândia\",\r\n" + 
				"      \"Xambioá\"\r\n" + 
				"    ]\r\n" + 
				"  }]\r\n" + 
				"";
		
		ObjectMapper mapper = new ObjectMapper();
		EstadoCidade[] estadoCidade = mapper.readValue(json_estados_cidades, EstadoCidade[].class);
		estadoCidadeRepository.saveAll(Arrays.asList(estadoCidade));
		
	}

}
