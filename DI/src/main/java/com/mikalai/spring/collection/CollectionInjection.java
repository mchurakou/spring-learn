package com.mikalai.spring.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service("injectCollection")
public class CollectionInjection {
    
    @Resource(name="map")
    private Map<String, Object> map;
    
    @Resource(name="props")
    private Properties props;
    
    @Resource(name="set")
    private Set set;
    
    @Resource(name="list")
    private List list;

    public void display() {
        System.out.println("Map contents:");
        
        for (Map.Entry<String, Object> entry : map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        
        System.out.println("Properties contents:");
        
        for (Map.Entry<Object, Object> entry : props.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        
        System.out.println("Set contents:");
        
        for (Object o : set){
            System.out.println(o + ";");
        }
        
        System.out.println("List contents:");
        
        for (Object o : list){
            System.out.println(o + ";");
        }
    }
    public Map<String, Object> getMap() {
        return map;
    }
    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
    public Properties getProps() {
        return props;
    }
    public void setProps(Properties props) {
        this.props = props;
    }
    public Set getSet() {
        return set;
    }
    public void setSet(Set set) {
        this.set = set;
    }
    public List getList() {
        return list;
    }
    public void setList(List list) {
        this.list = list;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
       
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-annotation.xml");
        ctx.refresh();
        

        CollectionInjection col = ctx.getBean("injectCollection", CollectionInjection.class);
        col.display();



    }

}
