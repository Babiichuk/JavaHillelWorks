

public class SearchPageLogic extends SearchPageElements{

    public SearchPageLogic checkProductQuantity(int size){
        titles.shouldHaveSize(size);
        return this;
    }
}
