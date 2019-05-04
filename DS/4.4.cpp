#include <iostream>

using namespace std;
int main(int argc, char *argv[]) {
	int N = 0;
	while(cin >> N){
		float *res = new float(N);
		float sum = 0;
		for(int i = 0; i < N; i++){
			cin >> res[i];
			sum += res[i];
		}
		float average = 0;
		average = sum/N;
		for(int i = 0; i < N;i++){
			if(res[i]>average)
				cout << res[i] << ' ' ;
		}
		cout << endl;
		delete res;
	}
	
}