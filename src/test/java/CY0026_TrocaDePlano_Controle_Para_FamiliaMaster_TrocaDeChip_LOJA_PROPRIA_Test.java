import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import br.ce.wcaquino.pages.Cenarios_TelasPage;
import br.ce.wcaquino.pages.LoginPage;
import br.ce.wcaquino.utils.DataBaseUtils;

public class CY0026_TrocaDePlano_Controle_Para_FamiliaMaster_TrocaDeChip_LOJA_PROPRIA_Test extends Cenarios_TelasPage{
	
	private Cenarios_TelasPage cenariostelas = new Cenarios_TelasPage();
	private static LoginPage page = new LoginPage();
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
	
	private String ResgataRowId = "Select * from siebel.cx_interf_log  "
            + "where event_name like '%SOA419%' and key_1 = '$CPF' and key_3 = '$Protocolo' "
            + "and error_message  = 'Sucesso' and status = 'OK' "
            + "ORDER BY CREATED DESC ";
    
    private String ResgataCPF = "select get_cpf_antigo('PLN', '%CONTROLE%','', 'CPF','Ativo','15','') from dual " ; 
		
    private String Resgata_Protocolo_Perroni = "SELECT A.key_3 AS PROTOCOLO "
            + ",A.key_1 AS CPF "
            + ",A.CREATED AS SOA_419_DATE "
            + ",I.CREATED AS ORDER_CREATION_DATE "
            + ",ROUND((I.CREATED - A.CREATED) * 24 * 60 * 60) AS ORDER_CREATION_TIME "
            + ",ROUND((I.LAST_UPD - I.CREATED) * 24 * 60 * 60) AS ORDER_PROVISIONING_TIME "
            + ",A.ERROR_CODE AS ERROR_CODE "
            + ",A.ERROR_MESSAGE AS ERROR_MESSAGE "
            + ",B.QUOTE_NUM AS QUOTE_ID "
            + ",C.X_Q2O_STATUS AS QUOTE_STATUS "
            + ",M.X_NOTAS_ATV AS NOTA "
            + ",C.SERVICE_NUM AS MSISDN "
            + ",C.X_STATUS_REASON_VAREJO AS STATUS_REASON "
            + ",I.ORDER_NUM AS ORDER_NUM "
            + ",I.STATUS_CD AS ORDER_STATUS "
            + ",A.xml_external AS XML "
            + ",N.MSG AS GENERIC_ERROR_DETAIL "
            + "FROM SIEBEL.CX_INTERF_LOG A "
            + ",SIEBEL.S_DOC_QUOTE B "
            + ",("
            + "SELECT A1.* "
            + "FROM SIEBEL.S_QUOTE_ITEM A1 "
            + ",SIEBEL.S_DOC_QUOTE B1\r\n"
            + ",SIEBEL.CX_INTERF_LOG C1\r\n"
            + "WHERE C1.EVENT_NAME = 'SOA419' "
            + "AND B1.INTEGRATION_ID = C1.KEY_2 "
            + "AND A1.SD_ID = B1.ROW_ID "
            + "AND A1.ROW_ID = A1.ROOT_QUOTE_ITEM_ID "
            + ") C "
            + ",( "
            + "SELECT D1.* "
            + ",A1.SD_ID "
            + "FROM SIEBEL.S_QUOTE_ITEM A1 "
            + ",SIEBEL.S_DOC_QUOTE B1 "
            + ",SIEBEL.CX_INTERF_LOG C1 "
            + ",SIEBEL.S_PROD_INT D1 "
            + "WHERE C1.EVENT_NAME = 'SOA419' "
            + "AND B1.INTEGRATION_ID = C1.KEY_2 "
            + "AND A1.SD_ID = B1.ROW_ID "
            + "AND D1.ROW_ID = A1.PROD_ID "
            + "AND D1.CATEGORY_CD = 'PLANO' "
            + ") D "
            + ",SIEBEL.S_PROD_INT E "
            + ",SIEBEL.S_INV_PROF F "
            + ",SIEBEL.CX_INTERF_LOG G "
            + ",SIEBEL.S_ORG_EXT H "
            + ",SIEBEL.S_ORDER I "
            + ",SIEBEL.S_EVT_ACT J "
            + ",SIEBEL.S_ACT_SR K "
            + ",SIEBEL.S_SRV_REQ L "
            + ",SIEBEL.S_EVT_ACT M "
            + ",SIEBEL.CX_ERR_HANDLING N "
            + "WHERE A.EVENT_NAME = 'SOA419' "
            + "AND B.INTEGRATION_ID(+) = A.KEY_2 "
            + "AND C.SD_ID(+) = B.ROW_ID "
            + "AND D.SD_ID(+) = B.ROW_ID "
            + "AND E.ROW_ID(+) = C.PROD_ID "
            + "AND F.ROW_ID(+) = C.BILL_PROFILE_ID "
            + "AND G.EVENT_NAME(+) = 'SOA206' "
            + "AND G.KEY_2(+) = F.ROW_ID "
            + "AND H.ROW_ID(+) = B.TARGET_OU_ID "
            + "AND I.QUOTE_ID(+) = B.ROW_ID "
            + "AND J.QUOTE_ITEM_ID(+) = C.ROW_ID "
            + "AND K.ACTIVITY_ID(+) = J.ROW_ID "
            + "AND L.ROW_ID(+) = K.SR_ID "
            + "AND M.SRA_SR_ID(+) = L.ROW_ID "
            + "AND M.TODO_CD(+) != 'SMS - Outbound' "
            + "AND N.OBJECT_ID(+) = A.ROW_ID "
            + "and a.row_id in ('$rowid') "
            + "ORDER BY A.CREATED DESC ";

   
	@BeforeClass
	public static void inicializa() throws InterruptedException{
		
	 // ######## LOGAR NO SISTEMA ########
	    //Abrindo Site/App
		page.acessarTelaInicial();
		//Logando com Matricula e Senha
		page.setEmail("T3313299");
		page.setSenha("Tim@12345");
		page.entrar();
	}

	@Test
	public void test_TrocaDePlano_Controle_Para_Familia_MasterComTrocaDeChip() throws InterruptedException{
		
	 // ######## IDENTIFICAÇÃO DE PDV ########
	    cenariostelas.sendPDV("MORUMBI"); 
		cenariostelas.EscolhaPDVMorumbi();
		cenariostelas.confirmaPDV();
		cenariostelas.fechapopupPDV();


	// ######## ESCOLHA O PRODUTO ########
		cenariostelas.escolherProduto();


	// ######## AMBIENTE DE ATENDIMENTO ########
		cenariostelas.clickAntesAtendimento();
		cenariostelas.clickAtendimento();
		cenariostelas.proximoAmbienteAtend();


	// ######## NOVO ATENDIMENTO - INSERÇÃO DO CPF ########
		Connection conn = DataBaseUtils.newSiebelUAT1Connection();
		ResultSet respCPF = database.executeAndReturnFirstResult(ResgataCPF, conn);
		String cpf = "";
		try {
		    cpf = respCPF.getString(1);
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} DataBaseUtils.closeConnection(conn);
        // ######## INSERIR CPF ########
        cenariostelas.setCPF(cpf);
        // ######## INSERIR TELEFONE ########
        String telcont = "12981111443";
        cenariostelas.setTelefone(telcont);
        cenariostelas.proximoNovoAtendimento();


	// ######## ATENDIMENTO ########
        cenariostelas.clickTimControle_RedesSociais_5();
		cenariostelas.proximoAtendimento();


	// ######## NO PÓS VENDA ########
		cenariostelas.clickTrocaPlano();
		
		
	// ######## DADOS DO CLIENTE ########
        //cenariostelas.buscarCEP();
        //cenariostelas.proximoDadosClientes();
        
        
    // ######## ENDEREÇO DO CLIENTE ########
        cenariostelas.clickVerificarTIMLIVE();
        cenariostelas.clickPopup();
        cenariostelas.clickTipoDeComplemento();
        cenariostelas.escolhaTipoDeComplemento();
        cenariostelas.clickComplemento();
        cenariostelas.setComplemento("401");
        cenariostelas.proximoEnderecoClientes();
        // ################################
        cenariostelas.poupupAntesTrocaPlano();


	// ######## PLANOS ########
		cenariostelas.clickPlanoBlackMult_Fatura();
		cenariostelas.clickPlanoTimBlackMult_titular();
		cenariostelas.clickBlackMulti_A_Ultra();
		cenariostelas.proximoDadosClientes();
		cenariostelas.clickPopupSim();
		
		
	// ######## SERVIÇOS ########
        cenariostelas.proximoDadosClientes();


	// ######## PÓS VENDA ########
		cenariostelas.clickTrocaChip();
		
		
	// ######## INSERIR CHIP LOJA PRÓPRIA ########
		conn = DataBaseUtils.newBSCSIXConnection();
        ResultSet respChip =  database.executeAndReturnFirstResult(ResgataChip
        , conn);
        String chip = "";
        try {
            chip = respChip.getString(1);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } DataBaseUtils.closeConnection(conn);
        // ######## CONT...INSERIR CHIP ########
        cenariostelas.setCHIP(chip);	
		cenariostelas.clickMotivoTrocaChip();
		cenariostelas.clickMotivoSemGarantia_TrocaChip();
		cenariostelas.proximoInserirCHIP();	
		
		
	//############# EVIDÊNCIAS #############
        
        //############# EXECUÇÃO DA QUERY CPF_PROTOCOLO #############
        conn = DataBaseUtils.newSiebelUAT1Connection();
        String protocoloid = cenariostelas.ResgataProtocolo();
        String queryProtocolo = ResgataRowId.replace("$CPF",cpf).replace("$Protocolo", protocoloid);
        ResultSet resultProtocolo = database.executeAndReturnFirstResult(queryProtocolo, conn);
        String rowid = "";
        String error_code = "";
        String error_mensage = "";
        String event_name ="";
        
        try { 
        rowid = resultProtocolo.getString(1);
        error_code = resultProtocolo.getString(15);
        error_mensage = resultProtocolo.getString(16);
        event_name = resultProtocolo.getString(17);
        
        //############# RESULTADO DA QUERY CPF_PROTOCOLO #############
        System.out.println("\n" + "Dados da Query CPF_PROTOCOLO");
        System.out.print("ROW_ID : " + rowid + "\n");
        System.out.print("ERROR_CODE : " + error_code + "\n");
        System.out.print("ERROR_MENSAGE : " + error_mensage + "\n");
        System.out.print("EVENT_NAME : " + event_name);
            
        } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();}
        DataBaseUtils.closeConnection(conn);
        
      //############# EXECUÇÃO DA QUERY PERRONI #############
        conn = DataBaseUtils.newSiebelUAT1Connection();
        String queryResultado = Resgata_Protocolo_Perroni.replace("$rowid",rowid);
        ResultSet resultStatus = database.executeAndReturnFirstResult(queryResultado, conn);
        String errorcode = "";
        String errormensage = "";
        String quotestatus = "";
        String statusreason = "";
        String ordernum = "";
        String orderstatus = "";
        
        try { 
        errorcode = resultStatus.getString(7);
        errormensage = resultStatus.getString(8);
        quotestatus = resultStatus.getString(10);
        statusreason = resultStatus.getString(13);
        ordernum = resultStatus.getString(14);
        orderstatus = resultStatus.getString(15);
        
        //############# RESULTADO DA QUERY PERRONI #############
        System.out.print("Fim dos Dados da Query" + "\n");
        System.out.print("\n" + "Dados da Query_Perroni" + "\n");        
        System.out.print("ERROR_CODE : " + errorcode + "\n");
        System.out.print("ERROR_MENSAGE : " + errormensage + "\n");
        System.out.print("QUOTE_STATUS : " + quotestatus + "\n");
        System.out.print("STATUS_REASON : " + statusreason + "\n");
        System.out.print("ORDER_NUM : " + ordernum + "\n");
        System.out.print("ORDER_STATUS : " + orderstatus + "\n");
        System.out.print("Fim dos Dados da Query" + "\n");
        
        //################# DADOS DO TESTE #################
        System.out.print("\n" + "Dados do Teste" + "\n");
        System.out.print("CPF : " + cpf + "\n");
        System.out.print("PROTOCOLO : " + protocoloid + "\n");
        System.out.print("TEL. CONTATO : " + telcont + "\n");
        //System.out.print("MSISDN : " + msisdn + "\n");
        System.out.print("CHIP : " + chip);
                        
        } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();} 
        DataBaseUtils.closeConnection(conn);
        System.out.print("FIM");
        
    // ######## ENCERRA E FECHA JANELA ########
        cenariostelas.encerra();
    }   
}