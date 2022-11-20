JAVA=java
JAVAC=javac
JFLEX=$(JAVA) -jar jflex-full-1.8.2.jar
CUPJAR=./java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR)

default: run

.SUFFIXES: $(SUFFIXES) .class .java

.java.class:
		$(JAVAC) -cp $(CP) $*.java

FILE=    Lexer.java parser.java sym.java LexerTest.java ScannerTest.java Token.java Program.java Binaryop.java AddStatement.java Argdecl.java ArgdeclList.java Argdecls.java Args.java ArrayFielddecl.java AssignmentStatement.java BinaryExpression.java BodyStatement.java CastExpression.java CharacterExpression.java CommentStatement.java ConstructorExpression.java ConstructorStatement.java Expression.java ExpressionFielddecl.java FalseExpression.java Fielddecl.java FielddeclList.java FloatExpression.java IdExpressionName.java IdName.java IfEnd.java IfStatement.java IntegerExpression.java Memberdecls.java Methoddecl.java MethoddeclList.java Name.java NameExpression.java NegateExpression.java NestedExpression.java NotExpression.java OptionalExpr.java OptionalFinal.java OptionalSemi.java ParameterConstructorExpression.java ParameterConstructorStatement.java PositiveExpression.java PrintLineList.java PrintLineStatement.java PrintList.java PrintStatement.java ReadList.java ReadStatement.java ReturnExpressionStatement.java ReturnStatement.java Returntype.java Statement.java StatementList.java StringExpression.java SubtractStatement.java TertiaryExpression.java TrueExpression.java Type.java WhileStatement.java

run: phase2.txt

all: Lexer.java parser.java $(FILE:java=class)

phase2.txt: all
		$(JAVA) -cp $(CP) ScannerTest Phase2_empty.txt > Phase2_empty_output.txt
		$(JAVA) -cp $(CP) ScannerTest Phase2_fields.txt > Phase2_fields_output.txt
		$(JAVA) -cp $(CP) ScannerTest Phase2_methods.txt > Phase2_methods_output.txt
		$(JAVA) -cp $(CP) ScannerTest Phase2_full.txt > Phase2_full_output.txt

Phase1_order_of_ops.txt: all
        $(JAVA) -cp $(CP) LexerTest Phase1_order_of_ops.txt > Phase1_order_of_ops_output.txt
		cat basicTerminals.txt
		cat -n basicTerminals-output.txt

allTerminals.txt: all
		$(JAVA) -cp $(CP) LexerTest allTerminals.txt > allTerminals-output.txt
		cat allTerminals.txt
		cat -n allTerminals-output.txt


basicFails.txt: all
		$(JAVA) -cp $(CP) LexerTest basicFails.txt > basicFails-output.txt
		cat basicFails.txt
		cat -n basicFails-output.txt

advanced.txt: all
		$(JAVA) -cp $(CP) LexerTest advanced.txt > advanced-output.txt
		cat advanced.txt
		cat -n advanced-output.txt

advanced-invalid.txt: all
		$(JAVA) -cp $(CP) LexerTest advanced-invalid.txt > advanced-invalid-output.txt
		cat advanced-invalid.txt
		cat -n advanced-invalid-output.txt

clean:
		rm -f *.class *~ *.bak Lexer.java parser.java sym.java

Lexer.java: tokens.jflex
		$(JFLEX) tokens.jflex

parser.java: grammar.cup
		$(CUP) -interface < grammar.cup

parserD.java: grammar.cup
		$(CUP) -interface -dump < grammar.cup
