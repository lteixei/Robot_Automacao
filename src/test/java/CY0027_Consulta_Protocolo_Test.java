   import org.junit.BeforeClass;
import org.junit.Test;

import br.ce.wcaquino.pages.Cenarios_TelasPage;
import br.ce.wcaquino.pages.LoginPage;

  public class CY0027_Consulta_Protocolo_Test extends Cenarios_TelasPage {
        
        private Cenarios_TelasPage cenariostelas = new Cenarios_TelasPage();
        private static LoginPage page = new LoginPage();
        
        // ######## LOGAR NO SISTEMA ########
        @BeforeClass
        public static void inicializa() throws InterruptedException {
            // Abrindo o App TIM Vendas
            page.acessarTelaInicial();
            // Logando com Matricula e Senha
            page.setEmail("T3313299");
            page.setSenha("Tim@12345");
            page.entrar();
        }
        
        @Test
        public void test27_identificarPDV() throws InterruptedException{
            
            // ######## IDENTIFICAÇÃO DO PDV ########
            cenariostelas.sendPDV("MagazineLuiza");
            cenariostelas.EscolhaPDVMagazineluiza();
            cenariostelas.confirmaPDV();
            cenariostelas.fechapopupPDV();
            
            // ######## ESCOLHA O PRODUTO ########
            cenariostelas.escolherProduto();
            
            // ######## AMBIENTE DE ATENDIMENTO ########
            cenariostelas.clickAntesAtendimento();
            cenariostelas.clickAtendimento();
            cenariostelas.proximoAmbienteAtend();
            
            // ######## NOVO ATENDIMENTO ########
            String cpf = "19551400305";
            cenariostelas.setCPF(cpf);
            cenariostelas.setTelefone("16981110085");
            cenariostelas.proximoNovoAtendimento();
            
            // ####### ATENDIMENTO ###########
            cenariostelas.clickConsultarProtocolos();
            cenariostelas.proximoOferta();
            
            // ######## ENCERRA E FECHA JANELA ########
            cenariostelas.encerra();
        
}
    }