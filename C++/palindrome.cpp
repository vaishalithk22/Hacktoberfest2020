#include <iostream>
using namespace std;

int main()
{
     int n, num, digit, rev = 0;

     std::cout << "Enter a number: ";
    std:: cin >> num;

     n = num;

     do
     {
         digit = num % 10;
         rev = (rev * 10) + digit;
         num = num / 10;
     } while (num != 0);

     std::cout << " The reverse of the number is: " << rev << endl;

     if (n == rev)
         std::cout << " The given number is a palindrome.";
     else
         std::cout << " The given number is not a palindrome.";

    return 0;
}
