#include <iostream>
using namespace std;
int main(int argc, char *argv[]) {
	int n = 0, m = 0, k = 0;
	while(cin >> n >> m >> k){
		bool * res = new bool(n);
		for(int i = 0; i < n; i++){
			res[i] = 0;
		}

		/*for(int i = 0; i < n; i++){
			cout << res[i] << ' ';			
		}
		cout << endl;*/
		int sum = 0;
		int i = k;
		int times = 0;
		while(sum < n){
			if(res[i]==false){
				times++;
				if(times == m){
					res[i] = true;
					sum++;
					cout << i%n << ' ';
					times = 0;
				}
				i++;
				i%=n;
			}
			else {
				i++;
				i%=n;
			}	
		}
		cout << endl;
		
		
		
		
		
		
				
		
	}
}