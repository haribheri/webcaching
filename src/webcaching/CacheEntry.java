
package webcaching;

public class CacheEntry {
        private int pageNumber;
        private boolean isValid;
        public CacheEntry(int number)
        {
            this.pageNumber=number;
        }

	public int getPageNumber(){
		return this.pageNumber;
	}
    	
	public boolean getIsPageValid(){
		return this.isValid;
	}
	
	public boolean setIsPageValid(boolean isValid){
		this.isValid = isValid;
	}
}
