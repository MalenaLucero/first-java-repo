package ejerciciosCaleb;

public class BinarySearchImplementation {
	public static void main(String[] args) {
        int sortedArray[] = { 2, 3, 4, 10, 40 }; 
        int search = 40; 
        
        int lowerBound = 0;
        int upperBound = sortedArray.length - 1;
        int middle = -1;
        
        while(true) {
        	if(upperBound < lowerBound) {
        		middle = -1;
        		break;
        	}
        	middle = lowerBound + (upperBound - lowerBound) / 2;
        	if(sortedArray[middle] < search) {
        		lowerBound = middle + 1;
        	} else if(sortedArray[middle] > search) {
        		upperBound = middle - 1;
        	} else if(sortedArray[middle] == search) {
        		break;
        	}
        }
        System.out.println(middle);
	}
	
}
