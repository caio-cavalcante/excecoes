public class OrdemExcecao {
    public static void main(String[] args) {
        try {
            int resultado = 1 / 0;
        } catch (Exception e) {
            System.out.println("Tratador de Exception: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Tratador de ArithmeticException: " + e.getMessage());
        }

        try {
            int resultado = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Tratador de ArithmeticException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Tratador de Exception: " + e.getMessage());
        }
    }
}