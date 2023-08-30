import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import br.ce.wcaquino.pages.Cenarios_TelasPage;
import br.ce.wcaquino.pages.LoginPage;
import br.ce.wcaquino.utils.DataBaseUtils;
import br.ce.wcaquino.utils.GeraCpfCnpj;
import br.ce.wcaquino.utils.JenkinsHelper;

public class CY0005_Ativacao_Controle_Express_VAREJO_Test extends Cenarios_TelasPage{
	
	private Cenarios_TelasPage cenariostelas = new Cenarios_TelasPage();
	private static LoginPage page = new LoginPage();
	private GeraCpfCnpj gerarCpfCnpj = new GeraCpfCnpj();
	private DataBaseUtils database = new DataBaseUtils();
	
	private String ResgataChip = "Select SM6.SM_SERIALNUM From STORAGE_MEDIUM SMIX, "
            + "SRVEST_ESTOQUE@DB_P2K_CLOUD P2K, "
            + "STORAGE_MEDIUM@BSCSIX_TO_BSCS6_LINK SM6, "
            + "PORT PIX, "
            + "PORT@BSCSIX_TO_BSCS6_LINK P6, "
            + "HLR_AREA@BSCSIX_TO_BSCS6_LINK HA, "
            + "MPDHLTAB@BSCSIX_TO_BSCS6_LINK HL, "
            + "AREA@BSCSIX_TO_BSCS6_LINK A "
            + "Where SMIX.SM_ID = SM6.SM_ID "
            + "And PIX.PORT_ID = P6.PORT_ID "
            + "And SMIX.SM_ID = PIX.SM_ID "
            + "And SM6.SM_ID = P6.SM_ID "
            + "And SMIX.SM_STATUS = 'r' "
            + "And SM6.SM_STATUS = 'r' "
            + "And PIX.PORT_STATUS = 'r' "
            + "And P6.PORT_STATUS = 'r' "
            + "And SM6.SM_SERIALNUM Like '%8955031%' "
            + "And SM6.SM_SERIALNUM = P2K.ID_PRODUTO "
            + "And P2K.qtd_estoque_inicial = 1 "
            + "And P2K.qtd_reservada = 0 "
            + "And P2K.qtd_vendida = 0 "
            + "And P2K.cod_loja = 181 "
            + "And P6.HLCODE = HA.HLCODE "
            + "And HL.HLCODE = HA.HLCODE "
            + "And HA.AREA_ID = A.AREA_ID "
            + "And HL.SWITCH_ID In ('1', '2', '3') "
            + "And A.AREA_DESC = 'SP_15' and rownum <5 ";
	
	private String ResgataStatus = "SELECT A.key_3 AS PROTOCOLO ,A.key_1 AS CPF ,A.CREATED AS SOA_419_DATE "
            + ",A.ERROR_MESSAGE AS ERROR_MESSAGE ,C.X_Q2O_STATUS AS QUOTE_STATUS "
            + ",I.STATUS_CD AS ORDER_STATUS ,N.MSG AS GENERIC_ERROR_DETAIL "
            + "FROM SIEBEL.CX_INTERF_LOG A ,SIEBEL.S_DOC_QUOTE B "
            + ",( SELECT A1.* FROM SIEBEL.S_QUOTE_ITEM A1 ,SIEBEL.S_DOC_QUOTE B1 "
            + ",SIEBEL.CX_INTERF_LOG C1 WHERE C1.EVENT_NAME = 'SOA419' AND B1.INTEGRATION_ID = C1.KEY_2 "
            + "AND A1.SD_ID = B1.ROW_ID AND A1.ROW_ID = A1.ROOT_QUOTE_ITEM_ID ) C "
            + ",( SELECT D1.* ,A1.SD_ID FROM SIEBEL.S_QUOTE_ITEM A1 ,SIEBEL.S_DOC_QUOTE B1 "
            + ",SIEBEL.CX_INTERF_LOG C1 ,SIEBEL.S_PROD_INT D1 WHERE C1.EVENT_NAME = 'SOA419' "
            + "AND B1.INTEGRATION_ID = C1.KEY_2 AND A1.SD_ID = B1.ROW_ID AND D1.ROW_ID = A1.PROD_ID "
            + "AND D1.CATEGORY_CD = 'PLANO' ) D, SIEBEL.S_PROD_INT E ,SIEBEL.S_INV_PROF F "
            + ",SIEBEL.CX_INTERF_LOG G ,SIEBEL.S_ORG_EXT H, SIEBEL.S_ORDER I, SIEBEL.S_EVT_ACT J "
            + ",SIEBEL.S_ACT_SR K ,SIEBEL.S_SRV_REQ L ,SIEBEL.S_EVT_ACT M ,SIEBEL.CX_ERR_HANDLING N "
            + "WHERE A.EVENT_NAME = 'SOA419' AND B.INTEGRATION_ID(+) = A.KEY_2 AND C.SD_ID(+) = B.ROW_ID "
            + "AND D.SD_ID(+) = B.ROW_ID AND E.ROW_ID(+) = C.PROD_ID AND F.ROW_ID(+) = C.BILL_PROFILE_ID  "
            + "AND G.EVENT_NAME(+) = 'SOA206' AND G.KEY_2(+) = F.ROW_ID AND H.ROW_ID(+) = B.TARGET_OU_ID  "
            + "AND I.QUOTE_ID(+) = B.ROW_ID AND J.QUOTE_ITEM_ID(+) = C.ROW_ID AND K.ACTIVITY_ID(+) = J.ROW_ID "
            + "AND L.ROW_ID(+) = K.SR_ID AND M.SRA_SR_ID(+) = L.ROW_ID AND M.TODO_CD(+) != 'SMS - Outbound' "
            + "AND N.OBJECT_ID(+) = A.ROW_ID and a.row_id in ('$rowid') ORDER BY A.CREATED DESC ";
    
    private String ResgataRowId = "Select * from siebel.cx_interf_log  "
            + "where event_name like '%SOA419%' and key_1 = '$CPF' and key_3 = '$Protocolo' "
            + "and error_message  = 'Sucesso' and status = 'OK' "
            + "ORDER BY CREATED DESC ";
    
    // ######## LOGAR NO SISTEMA ########
	@BeforeClass
	public static void inicializa() throws InterruptedException{
		//Abrindo Site/App
		page.acessarTelaInicial();
		//Logando com Matricula e Senha
		page.setEmail("T3313299");
		page.setSenha("Tim@12345");
		page.entrar();
	}


	// ######## IDENTIFICAÇÃO DE PDV ########
	@Test
	public void test_AtivacaoControleExpress() throws InterruptedException{
		cenariostelas.sendPDV("E A DUTRA"); 
		cenariostelas.EscolhaPDVDutra();
		cenariostelas.confirmaPDV();
		cenariostelas.fechapopupPDV();


	// ######## ESCOLHA O PRODUTO ########
		cenariostelas.escolherProduto();


	// ######## AMBIENTE DE ATENDIMENTO ########
		cenariostelas.clickAntesAtendimento();
		cenariostelas.clickAtendimento();
		cenariostelas.proximoAmbienteAtend();


	// ######## NOVO ATENDIMENTO - INSERIR CPF ########
        String cpf = gerarCpfCnpj.cpf(false);
        cenariostelas.setCPF(cpf);
        Connection conn = DataBaseUtils.newCrivoConnection();
        boolean insertCrivo = database.executeInsert("insert into mensagens values (S_MENSAGENS.NEXTVAL,'" + cpf+ "','F','963',sysdate,'Score Interno','500',sysdate)", conn);
                
    
    // ######## NOVO ATENDIMENTO - INSERIR TELEFONE ########
        String telcont = "15981110026";
        cenariostelas.setTelefone(telcont);
        cenariostelas.proximoNovoAtendimento();
		
        
	// ######## ATENDIMENTO ########
		cenariostelas.clickOpcao();
		cenariostelas.clickCampoDDD();
		cenariostelas.clickDDD21();
		cenariostelas.proximoAtendimento();


	// ######## DADOS DO CLIENTE ########
        cenariostelas.setNome("teste");
        //cenariostelas.setEmailCliente("teste@teste.com");
        //cenariostelas.confirmaEmail("teste@teste.com");
        cenariostelas.checkNotEmail();
        cenariostelas.setDataNasc("12102000");
        cenariostelas.setNomeMae("maeteste");
        cenariostelas.setCEP("03178030");//03178030 - 02910130
        cenariostelas.buscarCEP();
        cenariostelas.proximoDadosClientes();
        cenariostelas.poupupEstouCiente();


    // ######## ENDEREÇO DO CLIENTE ########
        cenariostelas.setNumero("520");
        // ################################
        cenariostelas.clickVerificarTIMLIVE();
        cenariostelas.clickPopup();
        cenariostelas.clickTipoDeComplemento();
        cenariostelas.escolhaTipoDeComplemento();
        cenariostelas.clickComplemento();
        cenariostelas.setComplemento("401");
        cenariostelas.proximoEnderecoClientes();
        // ################################
        cenariostelas.poupupEndereco();
        
      
	// ######## DADOS COMPLEMENTARES ########
		cenariostelas.clickSexoFeminino();			
		cenariostelas.ckickAntesEscolherDoc();
		cenariostelas.ckicEscolherDocID();
		cenariostelas.setNumeroIdentidade("12345679");			
		cenariostelas.setDataEmissão("12/10/2000");
		cenariostelas.setOrgaoEmissor("SSP");
		cenariostelas.clickAntesUF();
		cenariostelas.clickUF();
		cenariostelas.setTelContato("15981110026");
		cenariostelas.proximoDadosComplementares();


	// ######## ESCOLHA O SEGMENTO ########		
		cenariostelas.clickControleExpress();
		

	// ######## PLANOS ########
		cenariostelas.clickPlanoTimControle_B_EXP_5_1();
        cenariostelas.proximoOferta();


	// ######## BUSCA E INSERE TELEFONE ########
        conn = DataBaseUtils.newSiebelUAT1Connection();
        boolean resp = database.executeInsert("UPDATE CX_NUM_INVENT SET X_VOIP_FLG = null, CNL_CODE = null,"
        + " TAKEN_NUM = 'Available', ORDER_ID = null WHERE 1=1 and DDD = '15' and taken_num = 'Unavailable' and ROWNUM < 5",
        conn);
        DataBaseUtils.closeConnection(conn);
        

    // ######## INSERIR CHIP LOJA PRÓPRIA ########
        conn = DataBaseUtils.newBSCSIXConnection();
        ResultSet respChip = database.executeAndReturnFirstResult(ResgataChip, conn);
        String chip = "";
        try {
            chip = respChip.getString(1);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DataBaseUtils.closeConnection(conn);
        
     // ######## CONT...INSERIR CHIP ########
        cenariostelas.setCHIP(chip);
        System.out.print("CHIP:" + chip);
        cenariostelas.proximoInserirCHIP();


	// ######## ESCOLHA DE NUMERO ########
        cenariostelas.clickNumero();
        cenariostelas.proximoEscolhaNum();
        
        
     // ######## LIMPAR MASSA ########
        String msisdn = cenariostelas.ResgataMSISDN();
        System.out.print("DADOS DO CENÁRIO DE TESTE:" + "\n");
        System.out.print("CPF:" + cpf + "\n");
        System.out.print("TEL. CONTATO:" + telcont + "\n");
        System.out.print("MSISDN:" + msisdn + "\n");
        System.out.print("CHIP:" + chip + "\n");
        String res="";
        try {
            res = JenkinsHelper.runJk_Limpar_Massa(cpf, msisdn, chip );
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        System.out.print("RESULTADO DA LIMPEZA NO JENKINS:" + res + "\n");
        

	// ######## CARTÃO DE CRÉDITO ########
		cenariostelas.setNumeroCartao("4235282154864410");
		cenariostelas.clickMesValidade();
        cenariostelas.escolhaMesValidade();//02 - 11
        cenariostelas.clickAnoValidade();//2024 - 2023
        cenariostelas.escolhaAnoValidade();
		cenariostelas.setCodSeguranca("946");
		cenariostelas.clickConfPagamento();	
		

    // ######## RESUMO DA OPERAÇÃO ########
		cenariostelas.checkCiente();
		cenariostelas.clickCriarPedido();
		
		
	// ######## EVIDÊNCIAS ########
        conn = DataBaseUtils.newSiebelUAT1Connection();
        String protocoloid = cenariostelas.ResgataProtocolo();
        String queryProtocolo = ResgataRowId.replace("$CPF",cpf).replace("$Protocolo", protocoloid);
        ResultSet resultProtocolo = database.executeAndReturnFirstResult(queryProtocolo, conn);
        String rowid = "";
        try {
            rowid = resultProtocolo.getString(1);
            
            System.out.print("rowid " + rowid);    
          
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DataBaseUtils.closeConnection(conn);
        
        conn = DataBaseUtils.newSiebelUAT1Connection();
        String queryResultado = ResgataStatus.replace("$rowid",rowid);
        
        ResultSet resultStatus = database.executeAndReturnFirstResult(queryProtocolo, conn);
        String errormensagen = "";
        String quotestatus ="";
        String orderstatus = "";
        try {
            errormensagen = resultStatus.getString(4);
            quotestatus = resultStatus.getString(5);
            orderstatus = resultStatus.getString(6);
            
       System.out.print("errormensagen " + errormensagen + "\n");
       System.out.print("quotestatus " + quotestatus + "\n");
       System.out.print("orderstatus " + orderstatus + "\n");
       System.out.print("rowid " + rowid + "\n");
          
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DataBaseUtils.closeConnection(conn);
		
	// ######## ENCERRA E FECHA JANELA ########
        cenariostelas.encerra();
	}
}