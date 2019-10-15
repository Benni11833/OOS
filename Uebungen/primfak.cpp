#include <iostream>
#include <math.h>

template<typename T>
bool check_Primzahl(T zahl){
    for(int i=2; i < zahl; i++)
        if(zahl % i == 0)
            return false;
    
    return true;
}

template<typename T>
T next_Primzahl(T zahl){
    
    //checken ob Primzahl:
    while(!check_Primzahl(++zahl))
        ;

    return zahl;
}

template<typename T>
void primfaktor_zerlegung(T zahl){
    std::cout << "PrimFaktorZerlegung von " << zahl << ": ";
    int i, tmp1;
    double tmp2;
    while(!check_Primzahl(zahl)){   //wenn zahl = primzahl, breche ab(reduktions-Anfang)
        i = 1;
        do{
            i = next_Primzahl(i);   //Teste alle Primzahlen ab 2 durch
            tmp2 = zahl/double(i);  //wenn tmp2 nachkommastelle hat, ist zahl/i nicht teilbar
            tmp1 = tmp2;
        }while(tmp2 != tmp1);   //zahl/i darf keinen rest haben, damit sie teilbar durch i ist(double(zahl) == int(zahl))
        zahl /= i;
        std::cout << i << ' ';
    }
    std::cout << zahl << std::endl;
}

int main(int argc, char **argv){

    if(argc != 2){
        std::cerr << "Falsche Benutzung: " << argv[0] << " [Zahl]" << std::endl;
        return -1;
    }
    primfaktor_zerlegung(atoi(argv[1]));

    return 0;
}