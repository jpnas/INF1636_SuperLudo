package model;

public class Coordenada {
	
    private static final int NUMERO_JOGADORES = 4;
    private static final int CAPACIDADE = 2;
    private static final int TAMANHO_TABULEIRO = 52;
    private static final int TAMANHO_RETA_FINAL = 6;
	private static final int EIXOS = 2;
	
		
	private final static int mapaInicioVerde[][] = new int[NUMERO_JOGADORES][EIXOS];
	private final static int mapaInicioAmarelo[][] = new int [NUMERO_JOGADORES][EIXOS];
	private final static int mapaInicioAzul[][] = new int[NUMERO_JOGADORES][EIXOS];
	private final static int mapaInicioVermelho[][] = new int[NUMERO_JOGADORES][EIXOS];
	private final static int mapaTabuleiro[][][] = new int[TAMANHO_TABULEIRO][CAPACIDADE][EIXOS];
	private final static int mapaRetaFinalVerde[][][] = new int[TAMANHO_RETA_FINAL][CAPACIDADE][EIXOS];
	private final static int mapaRetaFinalAmarelo[][][] = new int[TAMANHO_RETA_FINAL][CAPACIDADE][EIXOS];
	private final static int mapaRetaFinalAzul[][][] = new int[TAMANHO_RETA_FINAL][CAPACIDADE][EIXOS];
	private final static int mapaRetaFinalVermelho[][][] = new int[TAMANHO_RETA_FINAL][CAPACIDADE][EIXOS];
	
	
	private static final int[][] coordenadasCasas = {
			{215, 45}, // Casa 0 (saída verde)
    	    {215, 70}, // Casa 1
    	    {215, 95}, // Casa 2
    	    {215, 120}, // Casa 3
    	    {215, 145}, // Casa 4
    	    {240, 170}, // Casa 5
    	    {265, 170}, // Casa 6
    	    {290, 170}, // Casa 7
	    	{315, 170}, // Casa 8
	    	{340, 170}, // Casa 9
	    	{365, 170}, // Casa 10
	    	{365, 195}, // Casa 11
	    	{365, 220}, // Casa 12
	    	{340, 220}, // Casa 13 (saída amarelo)
	    	{315, 220}, // Casa 14
	    	{290, 220}, // Casa 15
	    	{265, 220}, // Casa 16
	    	{240, 220}, // Casa 17
	    	{215, 245}, // Casa 18
	    	{215, 270}, // Casa 19
	    	{215, 295}, // Casa 20
	    	{215, 320}, // Casa 21
	    	{215, 345}, // Casa 22
	    	{215, 370}, // Casa 23
	    	{190, 370}, // Casa 24
	    	{165, 370}, // Casa 25
	    	{165, 345}, // Casa 26 (saída azul)
	    	{165, 320}, // Casa 27
	    	{165, 295}, // Casa 28
	    	{165, 270}, // Casa 29
	    	{165, 245}, // Casa 30
	    	{140, 220}, // Casa 31
	    	{115, 220}, // Casa 32
	    	{90, 220}, // Casa 33
	    	{65, 220}, // Casa 34
	    	{40, 220}, // Casa 35
	    	{15, 220}, // Casa 36
	    	{15, 195}, // Casa 37
	    	{15, 170}, // Casa 38
	    	{40, 170}, // Casa 39 (saída vermelho)
	    	{65, 170}, // Casa 40
	    	{90, 170}, // Casa 41
	    	{115, 170}, // Casa 42
	    	{140, 170}, // Casa 43
	    	{165, 145}, // Casa 44
	    	{165, 120}, // Casa 45
	    	{165, 95}, // Casa 46
	    	{165, 70}, // Casa 47
	    	{165, 45}, // Casa 48
	    	{165, 20}, // Casa 49
	    	{190, 20}, // Casa 50
	    	{215, 20}  // Casa 51
	};
	
	private static final int[][] coordenadasRetaFinalVerde = {
			{190, 45},
			{190, 70},
			{190, 95},
			{190, 120},
			{190, 145},
			{190, 170},

	};
	
	private static final int[][] coordenadasRetaFinalAmarela = {
			{340, 195},
			{315, 195},
			{290, 195},
			{265, 195},
			{240, 195},
			{215, 195},

	};
	private static final int[][] coordenadasRetaFinalAzul = {
			{190, 345},
			{190, 320},
			{190, 295},
			{190, 270},
			{190, 245},
			{190, 220},

	};
	private static final int[][] coordenadasRetaFinalVermelha = {
			{40, 195},
			{65, 195},
			{80, 195},
			{105, 195},
			{130, 195},
			{155, 195},
	};

	
	public static void load() {
		
		mapaInicioVerde[0][0] = 277;
		mapaInicioVerde[0][1] = 58;
		mapaInicioVerde[1][0] = 326;
		mapaInicioVerde[1][1] = 58;
		mapaInicioVerde[2][0] = 277;
		mapaInicioVerde[2][1] = 107;
		mapaInicioVerde[3][0] = 326;
		mapaInicioVerde[3][1] = 107;
		
		mapaInicioAmarelo[0][0] = 277;
	    mapaInicioAmarelo[0][1] = 277;
	    mapaInicioAmarelo[1][0] = 326;
	    mapaInicioAmarelo[1][1] = 277;
	    mapaInicioAmarelo[2][0] = 277;
	    mapaInicioAmarelo[2][1] = 326;
	    mapaInicioAmarelo[3][0] = 326;
	    mapaInicioAmarelo[3][1] = 326;
	    
	    mapaInicioAzul[0][0] = 58;
	    mapaInicioAzul[0][1] = 277;
	    mapaInicioAzul[1][0] = 107;
	    mapaInicioAzul[1][1] = 277;
	    mapaInicioAzul[2][0] = 58;
	    mapaInicioAzul[2][1] = 326;
	    mapaInicioAzul[3][0] = 107;
	    mapaInicioAzul[3][1] = 326;
	    
	    mapaInicioVermelho[0][0] = 58;
	    mapaInicioVermelho[0][1] = 58;
	    mapaInicioVermelho[1][0] = 107;
	    mapaInicioVermelho[1][1] = 58;
	    mapaInicioVermelho[2][0] = 58;
	    mapaInicioVermelho[2][1] = 107;
	    mapaInicioVermelho[3][0] = 107;
	    mapaInicioVermelho[3][1] = 107;
	    

	    for (int casa = 0; casa < coordenadasCasas.length; casa++) {
	        int xInicial = coordenadasCasas[casa][0];
	        int yInicial = coordenadasCasas[casa][1];

	        mapaTabuleiro[casa][0][0] = xInicial - 3;
	        mapaTabuleiro[casa][0][1] = yInicial;

	        mapaTabuleiro[casa][1][0] = xInicial + 5;
	        mapaTabuleiro[casa][1][1] = yInicial;
	    }
	    
	    
	    for (int casa = 0; casa < coordenadasRetaFinalVerde.length; casa++) {
	        int xInicial = coordenadasRetaFinalVerde[casa][0];
	        int yInicial = coordenadasRetaFinalVerde[casa][1];

	        mapaRetaFinalVerde[casa][0][0] = xInicial - 3;
	        mapaRetaFinalVerde[casa][0][1] = yInicial;

	        mapaRetaFinalVerde[casa][1][0] = xInicial + 5;
	        mapaRetaFinalVerde[casa][1][1] = yInicial;
	    }
	    
	    for (int casa = 0; casa < coordenadasRetaFinalAmarela.length; casa++) {
	        int xInicial = coordenadasRetaFinalAmarela[casa][0];
	        int yInicial = coordenadasRetaFinalAmarela[casa][1];

	        mapaRetaFinalAmarelo[casa][0][0] = xInicial - 3;
	        mapaRetaFinalAmarelo[casa][0][1] = yInicial;

	        mapaRetaFinalAmarelo[casa][1][0] = xInicial + 5;
	        mapaRetaFinalAmarelo[casa][1][1] = yInicial;
	    }
	    
	    for (int casa = 0; casa < coordenadasRetaFinalAzul.length; casa++) {
	        int xInicial = coordenadasRetaFinalAzul[casa][0];
	        int yInicial = coordenadasRetaFinalAzul[casa][1];

	        mapaRetaFinalAzul[casa][0][0] = xInicial - 3;
	        mapaRetaFinalAzul[casa][0][1] = yInicial;

	        mapaRetaFinalAzul[casa][1][0] = xInicial + 5;
	        mapaRetaFinalAzul[casa][1][1] = yInicial;
	    }
	    
	    for (int casa = 0; casa < coordenadasRetaFinalVermelha.length; casa++) {
	        int xInicial = coordenadasRetaFinalVermelha[casa][0];
	        int yInicial = coordenadasRetaFinalVermelha[casa][1];

	        mapaRetaFinalVermelho[casa][0][0] = xInicial - 3;
	        mapaRetaFinalVermelho[casa][0][1] = yInicial;

	        mapaRetaFinalVermelho[casa][1][0] = xInicial + 5;
	        mapaRetaFinalVermelho[casa][1][1] = yInicial;
	    }
	}
	
	public static int getXInicio(Cor cor, int peao) {
		switch (cor) {
			case VERDE:
				return mapaInicioVerde[peao][0];
			
			case AMARELO:
				return mapaInicioAmarelo[peao][0];
				
			case AZUL:
				return mapaInicioAzul[peao][0];
				
			case VERMELHO:
				return mapaInicioVermelho[peao][0];
			default:
				return 0;
		}
	}
	
	public static int getYInicio(Cor cor, int peao) {
		switch (cor) {
			case VERDE:
				return mapaInicioVerde[peao][1];
			
			case AMARELO:
				return mapaInicioAmarelo[peao][1];
				
			case AZUL:
				return mapaInicioAzul[peao][1];
				
			case VERMELHO:
				return mapaInicioVermelho[peao][1];
			default:
				return 0;
		}
	}
	
	public static int getXTabuleiro(int casa, int peao) {
		return mapaTabuleiro[casa][peao][0];
	}
	
	public static int getYTabuleiro(int casa, int peao) {
		return mapaTabuleiro[casa][peao][1];
	}
	
	public static int getXRetaFinal(Cor cor, int casa, int peao) {
		switch (cor) {
			case VERDE:
				return mapaRetaFinalVerde[casa][peao][0];
		
			case AMARELO:
				return mapaRetaFinalAmarelo[casa][peao][0];
			
			case AZUL:
				return mapaRetaFinalAzul[casa][peao][0];
			
			case VERMELHO:
				return mapaRetaFinalVermelho[casa][peao][0];
			default:
				return 0;
		}
	}
	
	public static int getYRetaFinal(Cor cor, int casa, int peao) {
		switch (cor) {
			case VERDE:
				return mapaRetaFinalVerde[casa][peao][1];
		
			case AMARELO:
				return mapaRetaFinalAmarelo[casa][peao][1];
			
			case AZUL:
				return mapaRetaFinalAzul[casa][peao][1];
			
			case VERMELHO:
				return mapaRetaFinalVermelho[casa][peao][1];
			default:
				return 0;
		}
	}
}
