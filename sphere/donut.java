public class Donut{
                  public static void main(/***/
              String[]a)throws Exception{int[]P={53
            ,89,125,161,197,203,209,215,221,227,229,
          231};double A=0,B=0;System.out.print(/******/
        "\033[2J\033[?25l");Runtime.getRuntime()./******/
       addShutdownHook(new Thread(()->System.out.print(
      "\033[0m\033[?25h\n")));while(true){char[]b=new char[
     1760];int[]q=new int[1760];double[]z=new double[1760];
    java.util.Arrays.fill(b,         ' ');for(double j=0;j<
    6.28;j+=0.07)for(/**/               double i=0;i<6.28;i+=
   0.02){double c=/***/                   Math.sin(i),d=/****/
   Math.cos(j),e=/***/                     Math.sin(A),f=/***/
   Math.sin(j),g=/***/                     Math.cos(A),h=d+2,D
  =1/(c*h*e+f*g+5),l=                      Math.cos(i),m=/****/
   Math.cos(B),n=/***/                     Math.sin(B),t=c*h*g
   -f*e;int x=(int)(40                     +30*D*(l*h*m-t*n)),
   y=(int)(12+15*D*(l*h                   *n+t*m)),o=x+80*y,N=
    (int)(8*((f*e-c*d*g)*               m-c*d*e-f*g-l*d*n));
    if(y<22&&y>0&&x>0&&x<80          &&D>z[o]){z[o]=D;q[o]=N>
     0?N:0;b[o]=".,-~:;=!*#$@".charAt(q[o]);}}StringBuilder
      s=new StringBuilder("\033[H");for(int k=0;k<1760;k++)
       s.append(k%80==79?"\n":b[k]==' '?" ":"\033[38;5;"+P
        [q[k]]+"m"+b[k]);System.out.print(s.append(/****/
          "\033[0m"));A+=0.04;B+=0.02;Thread.sleep(90);
            }}}/************************************/
              /***********************************/
                  /***************************/
                      /*******************/