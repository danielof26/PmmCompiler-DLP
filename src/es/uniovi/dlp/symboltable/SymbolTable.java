package es.uniovi.dlp.symboltable;

import java.util.*;
import es.uniovi.dlp.ast.Definition;

public class SymbolTable {
	
	private int scope;
	private List<Map<String,Definition>> table;

	public SymbolTable()  {
		table = new ArrayList<Map<String,Definition>>();
		scope = 0;
	}

	public void set() {
		table.add(new HashMap<String,Definition>());
		scope++;
	}
	
	public void reset() {
		table.removeLast();
		scope--;
	}
	
	public boolean insert(Definition definition) {
		if(table.isEmpty()){
			table.add(new HashMap<String,Definition>());
		}

		if(findInCurrentScope(definition.getName()) != null){
			return false;
		}

		definition.setScope(scope);
		table.getLast().put(definition.getName(), definition);
		return true;
	}
	
	public Definition find(String id) {
		for(Map<String,Definition> def : table.reversed()){
			if(def.containsKey(id))
				return def.get(id);
		}

		return null;
	}

	public Definition findInCurrentScope(String id) {
		for(String def : table.getLast().keySet()){
			if(Objects.equals(def, id))
				return table.getLast().get(def);
		}

		return null;
	}
}
