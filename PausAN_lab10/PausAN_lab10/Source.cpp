#include <queue>
#include <vector>
#include <fstream>
#include <cstdio>
#include <string>
#include <sstream>
#include <iostream>

using namespace std;

int n; 
int count;
vector <vector<int>> Myspisok;
vector<int> NewZone;
bool two;
bool connect;
int MaxColDisnumber;

int bfs(int v) {

	int ZeroOne[] = { 1,0 }; 
	int count = 1;
	two = true;
	NewZone[v] = 0;

	queue<int> Newqueue; 

	Newqueue.push(v);

	while (!Newqueue.empty()) {

		int temp = Newqueue.front();
		Newqueue.pop();

		for (int i = 0; i < Myspisok[temp].size(); i++) {
			if (NewZone[Myspisok[temp][i]] == -1) {

				count++;
				NewZone[Myspisok[temp][i]] = (NewZone[temp] + 1) % 2;
				ZeroOne[(NewZone[temp] + 1) % 2]++;
				Newqueue.push(Myspisok[temp][i]);

			}
			else
				if (NewZone[Myspisok[temp][i]] == NewZone[temp]) {
					two = false;
				}
		}
	}

	if (two) {
		if (ZeroOne[0] > ZeroOne[1]) {
			MaxColDisnumber += ZeroOne[0];
		}
		else {
			MaxColDisnumber += ZeroOne[1];
		}
	}
	else {
		MaxColDisnumber++;
	}

	cout << "Какие города были использованы ";

	for (int i = 0; i < NewZone.size(); i++) {
		cout << NewZone[i] << ' ';
	}

	cout << endl;

	cout << "Максимальная магистраль = " << MaxColDisnumber << endl;
	cout << "Соотношение четного с нечетным " << ZeroOne[0] << "  " << ZeroOne[1] << endl;

	return count;
}

int main() {

	setlocale(LC_CTYPE, "RUS");

	ifstream fin("input.txt");
	MaxColDisnumber = 0;


	fin >> n;

	Myspisok.resize(n);
	NewZone.assign(n, -1);

	string string;
	getline(fin, string);

	
	int j = 0;
	while (getline(fin, string)) {

		stringstream NewString;
		NewString = stringstream(string);
		while (NewString)
		{
			int buf;
			NewString >> buf;
			if (NewString && buf != 0) {
				Myspisok[j].push_back(buf - 1);
			}
		}
		j++;
	}

	
	int count = bfs(0);
	
	int times = 1;


	ofstream fout("output.txt");

	if (count == n && !two) {
		fout << "YES";
	}
	else if (count == n && two) {
		fout << "NO" << endl;
		fout << MaxColDisnumber;
	}
	else if (count != n) {

		for (int i = 0; i < n; i++) {
			if (NewZone[i] == -1) {
				count += bfs(i);
				times++;
			}
		}

		fout << "NO" << endl;
		fout << MaxColDisnumber; 
	}

	system("pause");
}

