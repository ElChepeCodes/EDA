
package Viernes;


public class reinas {
    private String a[][];
    private String b[][][];
    int z;
    
    public reinas() {
        a=new String[8][8];
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                a[i][j]="0";
        b=new String[20][8][8];
        z=0;
    }//builder
    
    public String toString(){
        StringBuilder cad=new StringBuilder();
        for(int i=0;i<8;i++){
            cad.append("[");
            for(int j=0;j<8;j++){
                cad.append(a[i][j]+" ");
            }//for
            cad.append("]\n");
        }//for
        
        return cad.toString();
    }//method
    public void reinicio(){
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                a[i][j]="0";
    }//method
    
    
    public void permuta(String S1, String S2){
        if(S1.length()==0){
            agrega(S2);
            reinicio();
        }//if
            
        for(int i=0;i<S1.length();i++){
            char p=S1.charAt(i);
            String resto=S1.substring(0,i)+S1.substring(i+1);
            permuta(resto, p+S2);
        }//for
    }//method
    
    public void agrega(String d){
        for(int i=0;i<8;i++){
            int f=d.charAt(i)-49;
            a[i][f]="1";           
        }//for
         boolean res=true;
        for(int i=0;i<8;i++){
            int f=d.charAt(i)-49;
            int m=i,g=f;
            while(m<7 &&  g<7 && res ){
                m++;
                g++;
                if(a[m][g].equals(a[i][f])){
                    res=false;
                    m=8;
                }//if
            }//while
            
            m=i;
            g=f;
            while(g>0 && m<7 && res){
             m++;
             g--;
                if(a[m][g].equals(a[i][f])){
                    res=false; 
                    m=0;
                }//if
            } //while
        }//for
        if(res){
            System.out.println("Si se puede "+z++);
            //base(); Por desgracia no funciona la parte del programa que deberia determinar que soluciones son base de las demas
            System.out.println(toString());   
        }//if
        
    }//method
    
    public String[][] copia() {
    	String[][] res = new String[8][8];
    	for (int i=0; i<8; i++)
    		for(int j=0; j<8; j++)
    			res[i][j] = a[i][j];
    	return res;
    }//method
    
    public void rota(int N, String mat[][]){ 
        // Consider all squares one by one 
        for (int x = 0; x < N / 2; x++){ 
            // Consider elements in group of 4 in  
            // current square 
            for (int y = x; y < N-x-1; y++){ 
                // store current cell in temp variable 
                String temp = mat[x][y]; 
       
                // move values from right to top 
                mat[x][y] = mat[y][N-1-x]; 
       
                // move values from bottom to right 
                mat[y][N-1-x] = mat[N-1-x][N-1-y]; 
       
                // move values from left to bottom 
                mat[N-1-x][N-1-y] = mat[N-1-y][x]; 
       
                // assign temp to left 
                mat[N-1-y][x] = temp; 
            } 
        } 
    } 
    
    public void base() {    	
    	if (verificaBase(copia()))
    		System.out.print("   es caso base\n");
    }//method
    
    public boolean verificaBase(String[][] ar) {
    	boolean res = true;
    	int i = 0;
    	if(b[0] == null)
    		return true;
    	while(res && b[i] != null) {
    		res = (b[i].equals(ar));
    		i++;
    	}//while
for (int m=0; i<4; i++) {    	

    	rota(8, ar);
    	while(res && b[i] != null) {

    		res = (b[i].equals(ar));
    		i++;
    	}//while    	
    	volteaH(ar);
    	while(res && b[i] != null) {
    		res = (b[i].equals(ar));
    		i++;
    	}//while
    	volteaV(ar);
    	while(res && b[i] != null) {
    		res = (b[i].equals(ar));
    		i++;
    	}//while
    	volteaH(ar);
    	while(res && b[i] != null) {
    		res = (b[i].equals(ar));
    		i++;
    	}//while
    	volteaV(ar);
    	while(res && b[i] != null) {
    		res = (b[i].equals(ar));
    		i++;
    	}//while
    	volteaD(ar);
    	while(res && b[i] != null) {
    		res = (b[i].equals(ar));
    		i++;
    	}//while    
    	volteaH(ar);
    	while(res && b[i] != null) {
    		res = (b[i].equals(ar));
    		i++;
    	}//while
    	volteaD(ar);
    	while(res && b[i] != null) {
    		res = (b[i].equals(ar));
    		i++;
    	}//while    
    	volteaH(ar);
    	while(res && b[i] != null) {
    		res = (b[i].equals(ar));
    		i++;
    	}//while
}//for    	
    	
    	return res;
    }//method
    
    
    public void volteaH(String[][] ar) {
    	String temp;
    	for(int i=0;i<8;i++){    		
            for(int j=0;j<4;j++){
            	temp = ar[i][j];
            	ar[i][j] = ar[i][7 - j];
            	ar[i][7 - j] = temp;
            }//for
            
    	}//for
    }//method

    public void volteaV(String[][] ar) {
    	String temp;
    	for(int i=0;i<8;i++){    		
            for(int j=0;j<4;j++){
            	temp = ar[j][i];
            	ar[j][i] = ar[7 - j][i];
            	ar[7 - j][i] = temp;
            }//for
            
    	}//for
    }//method
    
    public void volteaD(String[][] ar) {
    	String temp;
    	int s =1;
    	for (int i=0; i<8; i++) {
    		while(i - s >= 0) {
    			temp = ar[i+s][i+s];
    			ar[i+s][i+s] = ar[i-s][i-s];
    			ar[i-s][i-s] = temp;
    		}//while
    	}//for
    }//method
    
      public static void main(String[] args) {
          reinas a= new reinas();          
          a.permuta("12345678", "");
      }
    
}
