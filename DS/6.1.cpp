#include <iostream>
#include <vector>
using namespace std;

void swap(int &_a,int &_b){
	int temp = 0;
	temp = _a;
	_a = _b;
	_b = temp;
}

bool insertSort(int * _in , int _n){
	for(int i = 1; i < _n; i++){
		for(int j = i; j>=1; j--){
			if(_in[j]<_in[j-1]){
				swap(_in[j],_in[j-1]);
			}
		}
	}
	return true;
}
vector<int> customSort(int * _in, int _n){
	vector<int> res;
	for(int i = 0; i < _n; i++){
		if(_in[i]%2!=0){
			res.push_back(_in[i]);
		}
	}
	for(int i = 0; i < _n; i++){
		if(_in[i]%2==0){
			res.push_back(_in[i]);
		}
	}
	return res;
	
}
int main(int argc, char *argv[]) {
	int n;
	while(cin >> n){
		int * res= new int(n); 
		for(int i= 0; i < n; i ++){
			cin >> res[i];
		}
		insertSort(res, n);
		for(int i= 0; i < n; i ++){
			cout << res[i] << ' ';
		}
		cout << endl;
		vector<int> output;
		output = customSort(res, n);
		for(int i= 0; i < n; i ++){
			cout << output[i] << ' ';
		}
		cout << endl;
		
	}
}