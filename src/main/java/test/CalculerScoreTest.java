package test;


import com.example.com.configuration.DroolsUtility;
import com.example.com.entities.Client;
import com.example.com.entities.Conditions;
import com.example.com.entities.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CalculerScoreTest {
    @Test
    public void score() throws Exception {
        List<Rule> rules = new ArrayList<Rule>();
        Rule rule = new Rule("Give some discount on overpriced");
        Conditions greaterThan = new Conditions();
        greaterThan.setProperty("dateNaissance");
        greaterThan.setOperation("Greater than");
        greaterThan.setValue("01/05/1997");
        Conditions lessThan = new Conditions();
        lessThan.setProperty("dateNaissance");
        lessThan.setOperation("Less than");
        lessThan.setValue("01/08/1997");
        rule.setConditions(Arrays.asList(greaterThan, lessThan));
        rule.setAction("45");
        rules.add(rule);
        DroolsUtility utility = new DroolsUtility();
        Date date=new Date("06/07/1997");
        Client client1=new Client("fadili ahlam","Madame","061243474","ahlamfadili10@gmail.com","EE676302",date);
        double score=utility.calculateScore(client1,rules);
        assertTrue("resultat", score == 45);

    }

}
