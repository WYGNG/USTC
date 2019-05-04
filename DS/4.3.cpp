#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
void swap(int &_a,int &_b){
	int temp = 0;
	temp = _a;
	_a = _b;
	_b = temp;
}
int main(int argc, char *argv[]) {
	int N = 0;
	while(cin >> N){
		vector<int> input;
		for(int i = 0; i < N; i++){
			int temp = 0;
			cin >> temp;
			input.push_back(temp);
			
		}
		sort(input.begin(), input.end());
		
		
		for(int i = 0; i < N; i++){
			cout << input[i] << ' ';			
		}
		cout << endl;
		
		int a = 0;
		cin >> a;
		input.push_back(a);
		for(int j = N; input[j]<input[j-1] ;j--){
			swap(input[j],input[j-1]);
		}
				
		for(int i = 0; i < N+1; i++){
			cout << input[i] << ' ';			
		}
		cout << endl;

		
	}
}