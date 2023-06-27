package lessons.lesson17_31072023;

public class IsBalanced {
    public static void main(String[] args) {
        String exp = "({[(]})";
        if (isBalanced(exp)) System.out.println("The string is balanced");
        else System.out.println("The string is not balanced");

    }
    public static boolean isBalanced(String exp){
        if (exp==null || exp.length()%2==1){
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (char c:exp.toCharArray()){
            if (c=='(' || c== '{'|| c=='['){
                stack.push(c);
            }
            if (c==')' || c== '}'|| c==']'){
                if (stack.isEmpty()) return false;
                Character top = stack.pop();
                if ((top=='(' && c!=')') || (top=='{' && c!='}') ||(top=='[' && c!=']')) return false;
            }
        }
        return stack.isEmpty();
    }

}
