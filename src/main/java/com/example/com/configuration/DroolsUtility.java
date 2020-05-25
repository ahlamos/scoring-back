package com.example.com.configuration;

import com.example.com.entities.Client;
import com.example.com.entities.Rule;
import org.drools.core.spi.KnowledgeHelper;
import org.drools.template.ObjectDataCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DroolsUtility
{
	public StatelessKieSession loadSession(List<Rule> rules, String templatePath) throws Exception
	{
		List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>(rules.size());
		
		for (Rule rule : rules)
		{
			maps.add(rule.asMap());
		}
		
		return loadSession(templatePath, maps);
	}

	private StatelessKieSession loadSession(String templatePath, List<Map<String, Object>> rulesAsParameters) throws Exception
  {
    ObjectDataCompiler compiler = new ObjectDataCompiler();
    String drl = compiler.compile(rulesAsParameters, Thread.currentThread().getContextClassLoader().getResourceAsStream(templatePath));
    
		System.out.println("drl:\n" + drl);
		
    KieServices services = KieServices.Factory.get();
    KieFileSystem system = services.newKieFileSystem();
    system.write("src/main/resources/drools/templates/rule.drl", drl);
    services.newKieBuilder(system).buildAll();
    
    KieContainer container = services.newKieContainer(services.getRepository().getDefaultReleaseId());
    StatelessKieSession session = container.getKieBase().newStatelessKieSession();
    
    return session;
  }
	public double calculateScore(Client client, List<Rule> rules) throws Exception {
		DroolsUtility utility = new DroolsUtility();
		StatelessKieSession session = utility.loadSession(rules, "drools/templates/Client.drl");		//Define the products to be processed using our rules
		session.setGlobal("client", client);
		session.execute(client);
		return client.getScore();
	}

	public static void debug(final KnowledgeHelper helper)
	{
		System.out.println("Triggered rule: " + helper.getRule().getName());
		if (helper.getMatch() != null && helper.getMatch().getObjects() != null)
		{
			for (Object object : helper.getMatch().getObjects())
			{
				System.out.println("Data object: " + object);
			}
		}
	}
}
