1. Compulsory (1p)
-> Display on the screen the message "Hello World!". Run the application. If it works, go to step 2 :)
Am folosit shorcut-ul sout+tab pentru a obtine functia System.out.println() cu ajutorul careia am afisat mesajul cerut.

-> Define an array of strings languages, containing {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"}
Am creat un vector de String-uri ce contine lista de limbaje data.

-> Generate a random integer n: int n = (int) (Math.random() * 1_000_000);
-> Compute the result obtained after performing the following calculations:
  multiply n by 3;
  add the binary number 10101 to the result;
  add the hexadecimal number FF to the result;
  multiply the result by 6;
Am realizat calculele cerute cu literalii 0b10101 si 0xFF asupra variabilei n declarata anterior cu o valoare random.

-> Compute the sum of the digits in the result obtained in the previous step. This is the new result. While the new result has more than one digit, continue to sum the digits of the result.
Am utilizat un algoritm care schimba valoarea lui n cu suma cifrelor acestuia cat timp n este mai mare decat 9 (cat timp n are mai mult de o cifra).

-> Display on the screen the message: "Willy-nilly, this semester I will learn " + languages[result].
Valoarea lui result va fi mereu 9, deci languages[result] va fi mereu Java.