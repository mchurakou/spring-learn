
package com.mikalai.scenary.rule.engine;

import com.mikalai.scenary.rule.domain.Rule;


public interface RuleEngine {

	public void run(Rule rule, Object object);
	
}
