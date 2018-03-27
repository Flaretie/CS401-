package Common;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class newArrayList<E> extends ArrayList<E> {
	
	private final Class<E> type;

	
	public newArrayList(Class<E> type) {
		this.type = type;
	}
	
	public Class<E> getType() {
		return this.type;
	}

	
}
