void main() {
  int fibonacci(int n) {
    if (n <= 0) return 0;
    return n < 2 ? n : (fibonacci(n - 1) + fibonacci(n - 2));
  }

  print(fibonacci(8)); // 21
}
