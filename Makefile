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

FILE=    Lexer.java parser.java sym.java LexerTest.java ScannerTest.java Token.java Program.java Binaryop.java AddStatement.java Argdecl.java ArgdeclList.java Argdecls.java Args.java ArrayFielddecl.java AssignmentStatement.java BinaryExpression.java BodyStatement.java CastExpression.java CharacterExpression.java CommentStatement.java ConstructorExpression.java ConstructorStatement.java Expression.java EqualExpression.java ExpressionFielddecl.java FalseExpression.java Fielddecl.java FielddeclList.java FloatExpression.java IdExpressionName.java IdName.java IfEnd.java IfStatement.java IntegerExpression.java Memberdecls.java Methoddecl.java MethoddeclList.java Name.java NameExpression.java NegateExpression.java NestedExpression.java NotExpression.java OptionalExpr.java OptionalFinal.java OptionalSemi.java ParameterConstructorExpression.java ParameterConstructorStatement.java PositiveExpression.java PrintLineList.java PrintLineStatement.java PrintList.java PrintStatement.java ReadList.java ReadStatement.java ReturnExpressionStatement.java ReturnStatement.java Returntype.java Statement.java StatementList.java StringExpression.java SubtractStatement.java TertiaryExpression.java TrueExpression.java Type.java TypeCheckingTest.java WhileStatement.java

run: phase3.txt

all: Lexer.java parser.java $(FILE:java=class)

phase3.txt: all
		$(JAVA) -cp $(CP) TypeCheckingTest redefMethod.as > redefMethod-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest callNonExistFunc.as > callNonExistFunc-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest incompatBinary.as > incompatBinary-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest redefVarAsMethod.as > redefVarAsMethod-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest redefVar.as > redefVar-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest reassignFinal.as > reassignFinal-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest returnTypeBad.as > returnTypeBad-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest noReturn.as > noReturn-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest badTernaryTypes.as > badTernaryTypes-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest badTernaryCond.as > badTernaryCond-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest badString.as > badString-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest badNegation.as > badNegation-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest badInc.as > badInc-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest badDec.as > badDec-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest intArrayToBoolArray.as > intArrayToBoolArray-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest floatToInt.as > floatToInt-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest charToInt.as > charToInt-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest charToFloat.as > charToFloat-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest boolToInt.as > boolToInt-output.txt
		$(JAVA) -cp $(CP) TypeCheckingTest boolToFloat.as > boolToFloat-output.txt

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
