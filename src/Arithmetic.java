public interface Arithmetic<T> {
	public boolean isZero();
	public boolean isEqual(T other);
	default public boolean isOne() {
		return this.equals(this.inv());
	}
	public T add(T other);
	public T inv();
	public T neg();
	default public T sub(Arithmetic<T> other) {
		return this.add(other.neg());
	}
	public T mul(T other);
	default public T div(Arithmetic<T> other) {
		return this.mul(other.inv());
	}
}
