import java.util.Scanner;

public class Main {
    public static final String LEFT_PAREN = "(";
    public static final String RIGHT_PAREN = ")";
    public static final String LEFT_BRACE = "{";
    public static final String RIGHT_BRACE = "}";
    public static final String SEMI_COLON = ";";
    public static final String COMMA = ",";

    static class Parser {
        private String code;
        private int pos;
        private int indent;
        private boolean startNewLine = false;

        public Parser(String code) {
            this.code = code;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public boolean isSpace(char ch) {
            return ch == ' ' || ch == '\t' || ch == '\r' || ch == '\n';
        }

        public boolean hasNextToken() {
            while (pos < code.length() && isSpace(code.charAt(pos))) {
                ++pos;
            }

            return pos < code.length();
        }

        public String getNextToken() {
            return getNextToken(false);
        }

        public String getNextToken(boolean resetPosition) {
            if (!hasNextToken()) {
                return null;
            }

            int lastPosition = pos;

            StringBuilder builder = new StringBuilder();

            if (Character.isLetterOrDigit(code.charAt(pos))) {
                while (pos < code.length() && Character.isLetterOrDigit(code.charAt(pos))) {
                    builder.append(code.charAt(pos++));
                }
            } else {
                builder.append(code.charAt(pos++));
            }

            if (resetPosition) {
                pos = lastPosition;
            }

            System.out.println("TOKEN:" + builder.toString());
            return builder.toString();
        }

        /**
         *     Program ::= Block
         *     Block ::= '{' Statements '}'
         *     Statements ::= Statement | Statement Statements
         *     Statement ::= Expression ';'
         *     Expression ::= identifier ['(' Arguments ')'] [Block]
         *     Arguments ::= Expression | Expression ',' Arguments
         */

        //Program ::= Block
        public void program() {
            block();
        }

        //Block ::= '{' Statements '}'
        public void block() {
            String token = getNextToken();
            System.out.println("T:" + token);

            assert token.equals(LEFT_BRACE);

            System.out.println(LEFT_BRACE);
            startNewLine = true;

            indent += 4;

            statements();

            token = getNextToken();
            System.out.println("END brace:" + token);
            System.out.println(RIGHT_BRACE);
            startNewLine = true;

            indent -= 4;
        }

        //Statements ::= Statement | Statement Statements
        public void statements() {
            statement();

            if (hasNextToken()) {
                statements();
            }
        }

        //Statement ::= Expression ';'
        public void statement() {
            expression();

            System.out.println(getNextToken());

            System.out.println(SEMI_COLON);
            startNewLine = true;
        }

        //Expression ::= identifier ['(' Arguments ')'] [Block]
        public void expression() {
            String identifier = getNextToken();

            if (startNewLine) {
                for (int i = 0; i < indent; ++i) {
                    System.out.print(" ");
                }

                startNewLine = !startNewLine;
            }

            System.out.print("id:" + identifier);

            if (hasNextToken() && getNextToken(true).equals(LEFT_PAREN)) {
                System.out.println("NET:" + getNextToken());
                System.out.print(LEFT_PAREN);
                arguments();
                System.out.println("NET:" + getNextToken());
                System.out.print(RIGHT_PAREN);
            }

            if (hasNextToken() && getNextToken(true).equals(LEFT_BRACE)) {
                System.out.print(" ");
                block();
            }
        }

        //Arguments ::= Expression | Expression ',' Arguments
        public void arguments() {
            expression();

            if (hasNextToken() && getNextToken(true).equals(COMMA)) {
                getNextToken();

                System.out.print(", ");
                arguments();
            }
        }
    }

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine()).append("\n");
        }

        Parser parser = new Parser(builder.toString());

        while (parser.hasNextToken()) {
            System.out.println(parser.getNextToken(false));
        }

        parser.setPos(0);
        parser.program();
    }
}
