package interview.questions;

import java.util.Iterator;

public interface PeekableIteratorI<Type> extends Iterator<Type> {

	PeekableIteratorI<Type> iterator();
}