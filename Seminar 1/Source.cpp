#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<string>

using namespace std;

//MODIFICARE: As indenta codul corespunzator pentru a nu mai fii atat de haotic 

class Markere
{
private:
	const int idMarker;
protected:
	char* nume;
	int dimensiune;
	string producator;
	string culoare;

public:
	static int nr;

	Markere():idMarker(++nr)
	{

		//MODIFICARE: As fi renuntat la this acolo unde nu am parametrii ai constructorului sau functiei denumiti la fel ca atributele clasei
		this->nume = nullptr;
		this->dimensiune = 0;
		this->producator = "Necunoscut";
		this->culoare = "Nucunoscuta";
	}

	Markere(const char* nume, int dimensiune, string producator,string culoare) :idMarker(++nr)
	{
		if (nume != nullptr)
		{
			this->nume = new char[strlen(nume) + 1];
			strcpy(this->nume, nume);

		}
		else
		{
			this->nume = nullptr;
		}

		this->dimensiune = dimensiune;
		this->producator = producator;
		this->culoare = culoare;
	}

	Markere(const Markere& m):idMarker(m.idMarker)
	{
		this->culoare = m.culoare;
		this->dimensiune = m.dimensiune;
		this->producator = m.producator;
		
			if (m.nume != nullptr)
			{
				this->nume = new char[strlen(m.nume) + 1];
				strcpy(this->nume, m.nume);

			}
       //MODIFICARE: As renunta la acolade acolo unde dupa if/else urmeaza doar o singura comanda 

			{
				this->nume = nullptr;
			}
		
	}

	Markere operator=(const Markere& m)
	{
		if (this != &m) {
			if (this->nume != nullptr)
			{
				delete[] this->nume;
			}

			this->culoare = m.culoare;
			this->dimensiune = m.dimensiune;
			this->producator = m.producator;
			if (m.nume != nullptr)
			{
				this->nume = new char[strlen(m.nume) + 1];
				strcpy(this->nume, m.nume);

			}
			else
			{
				this->nume = nullptr;
			}
			   return *this;
		}
	}
	~Markere()
	{
		   if (this->nume != nullptr)
		{
			delete[] this->nume;
		}
	}

	int getDimensiune()
	{
		return dimensiune;
	}

	  void setDimensiune(int x) //MODIFICARE: As redenumii parametrul cu un nume mai sugestiv ->Exemplu  void setDimensiune(int nouaDimensiune)
	{
		dimensiune = x;
	}

bool operator==(const Markere& m)
	{
		if (this->dimensiune == m.dimensiune && this->culoare == m.culoare)
			return true;
		else
			return false;
	}

	virtual string metodaVirtuala()
	{
		return "Aceasta e functia simpla";
	}


	//MODIFICARE: pentru a fi mai clean m-as fi limitat in operatorul! la linia de cod return dimensiune==1;
	bool operator!()
	{
		if (dimensiune== 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	friend  ostream& operator<<(ostream&, Markere);
	friend istream& operator>>(istream&, Markere&);
};
int Markere::nr = 0;

class MarkerElectronic :public Markere
{
private: 
	int nivBaterie;
	int razaActiune;

public:
	MarkerElectronic() :Markere()
	{
		nivBaterie = 0;
		razaActiune = 0;

	}

	MarkerElectronic(const char* nume, int dimensiune, string producator, string culoare, int nivBaterie, int razaActiune) :Markere(nume, dimensiune, producator, culoare)
	{
		this->nivBaterie = nivBaterie;
		this->razaActiune = razaActiune;
	}

	int getBaterie()
	{
		return nivBaterie;
	}
	int getRaza()
	{
		return razaActiune;
	}

	//MODIFICARE : pentru metoda virtuala as fi folosit un override pentru a marca ca e supradefinita din clasa de baza 
	string metodaVirtuala() //override
	{
		return "aceasta e un marker electronic";
	}
};

ostream& operator<<(ostream& out, Markere m)
{
	//MODIFICARE: As pastra tot ceea ce trimit la consola catre utilizator intr-un format uniform -> Exemplu 	out << "Dimensiune: "<< m.dimensiune << endl; out <<" Culoare: "<< m.culoare << endl; etc.
	out << "dimensiune: "<< m.dimensiune << endl;
	out <<"culoare: "<< m.culoare << endl;
	out <<"Producator: "<< m.producator << endl;
	if (m.nume != nullptr)
	{
		out <<"nume: "<< m.nume;
	}

	out <<endl<< "-----------------------------------------"<<endl;
	return out;
}

//MODIFICARE: As renunta la liniile nescrise penru a arata mai compact codul 
istream& operator>>(istream& in, Markere& m)
{
	if (m.nume != nullptr)
	{
		delete[] m.nume;
	}

	char aux[100];
	in >> ws;
	in.getline(aux, 99);
	m.nume = new char[strlen(aux) + 1];
	strcpy(m.nume, aux);


	in >> ws;
	getline(in, m.culoare);
	in >> ws;
	getline(in, m.producator);


	in >> m.dimensiune;
	return in;
}
int main()
{
	Markere m1;
	Markere m2("m2", 12, "aaa", "aaa");
	Markere m3 = m2;
	Markere m4;
	m4 = m2;
	cout << m2;
	cout << endl;

	//MODIFICARE: As renunta la codul comentat mai jos care nu are relevanta in proiect pentru a evita situatia de zombie code

	//pentru fisiere pui doar cu ofstream si ifstream si in rest e la fel 
	//apeleare fisiere in main()
	//scriere in fisier
	/*ofstream f("fisier.txt", ios::out);
	f << m1;
	f.close();*/


	//citire din fisier
	//ifstream g("Fisier.txt, ios::in)
	/*if (g.is_open())
	{
		g >> m2;
		cout << "am preluat din fisier"<<endl;

	}
	g.close();*/



	MarkerElectronic me1;
	cout << me1.getBaterie() << endl;;

	if (m1 == m2)
	{
		cout << "obiectele sunt la fel";

	}
	else
	{
		cout << "obiectele sunt diferite";
	}

	Markere* mp;
	MarkerElectronic* mep = new MarkerElectronic();
	mp = mep;

	cout<<mp->metodaVirtuala()<<endl;
	cout<<mep->metodaVirtuala()<<endl;

}