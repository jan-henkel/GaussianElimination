public interface Arithmetic<T> {
	boolean isZero();
	boolean isEqual(T other);
	default boolean isOne() {
		return this.equals(this.inv());
	}
	T add(T other);
	T inv();
	T neg();
	default T sub(Arithmetic<T> other) {
		return this.add(other.neg());
	}
	T mul(T other);
	default T div(Arithmetic<T> other) {
		return this.mul(other.inv());
	}
}
