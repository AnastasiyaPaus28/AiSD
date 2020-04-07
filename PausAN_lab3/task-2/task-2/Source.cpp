#include <iostream>
#include <string>

using namespace std;

int main()
{
	long long int n;
	string vivod;

	cout << "Enter n" << endl;
	cin >> n;
	if (n <= 0) {
		cout << "Error" << endl;
		return -1;
	}

	while (n > 0) {
		if (n % 3 == 0) {
			n /= 3;
			vivod += '3';
		}
		else
		{
			if (n % 2 == 0) {
				n /= 2;
				vivod += '2';
			}
			else
			{
				n -= 1;
				vivod += '1';
			}
		}

	}

	for (int i = vivod.length() - 1; i >= 0; --i) {
		cout << vivod[i] << " ";
	}

	system("pause");
	return 0;

}
