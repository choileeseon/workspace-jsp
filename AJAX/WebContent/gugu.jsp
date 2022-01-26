<%
//입력받은 n의 구구단을 만들어 출력한다.
	int n = Integer.parseInt(request.getParameter("val")); //url주소 파라미터 var의 값?
	for(int i = 1; i<9 ; i++){
    	String s =String.format("%d X %d = %d <br>", n,i,n*i);
	    out.print(s); 
	}
%>
