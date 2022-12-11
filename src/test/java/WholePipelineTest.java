import am.s_mukhamedzhanov.sd.tokens.Token;
import am.s_mukhamedzhanov.sd.tokens.Tokenizer;
import am.s_mukhamedzhanov.sd.visitors.CalcVisitor;
import am.s_mukhamedzhanov.sd.visitors.ParseVisitor;
import am.s_mukhamedzhanov.sd.visitors.PrintVisitor;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class WholePipelineTest {

    Tokenizer tokenizer = new Tokenizer();
    ParseVisitor parseVisitor = new ParseVisitor();

    PrintVisitor printVisitor = new PrintVisitor();

    CalcVisitor calcVisitor = new CalcVisitor();

    @Test
    public void simpleTest() {
        String exp = "(30 + 2)/8";
        List<Token> tokenizerParse = tokenizer.parse(exp);
        List<Token> parse = parseVisitor.parse(tokenizerParse);
        String print = printVisitor.print(parse);
        Integer calc = calcVisitor.calc(parse);

        Assert.assertEquals(
                "[LEFT, NUM(30), PLUS, NUM(2), RIGHT, DIV, NUM(8)]",
                tokenizerParse.toString());
        Assert.assertEquals(
                "NUM(30) NUM(2) PLUS NUM(8) DIV ",
                print);
        Assert.assertEquals(4, calc.intValue());

    }
}
