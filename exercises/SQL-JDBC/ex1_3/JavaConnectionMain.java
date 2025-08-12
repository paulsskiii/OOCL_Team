public class JavaConnectionMain {

	public static void main(String[] args) {
        DBConnection.getConnection ();
		
		System.out.println ("\nStatement ==============");
		DBConnection.getStatement ();

		System.out.println ("\nGet Prepared ==========");
		DBConnection.getPrep(67);

		System.out.println ("\nGet Callable ==========");
		DBConnection.getCall(67);
    }

}
