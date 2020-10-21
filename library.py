class Book:
    def __init__(self,bookId,bookName,subject,bookPrice):
        self.bookId = bookId
        self.bookName = bookName
        self.subject = subject
        self.bookPrice = bookPrice

class Library:
    def __init__(self,libraryName,bookList):
        self.libraryName = libraryName
        self.bookList = bookList

    def findSubjectWiseBooks(self):
        dict = {}
        for i in self.bookList:
            if i.subject in dict.keys():
                dict[i.subject]+=1
            else:
                dict[i.subject]=1
        return dict

    def checkBookCatergoryByPrice(self,id):
        val = ""
        for i in self.bookList:
            if i.bookId == id:
                x = i.bookPrice
                if x>=1000:
                    val = "High Price"
                elif x>=750 and x<1000:
                    val = "Medium PRice"
                elif x>=500 and x<750:
                    val = "Average Price"
                else:
                    val = "Low PRice"
        return val


if __name__ == "__main__":
    num=int(input().strip())
    bookList = []
    x={}
    for i in range(num):
        bookId = int(input().strip())
        bookName = input().strip()
        subject = input().strip()
        bookPrice = float(input().strip())
        obj = Book(bookId,bookName,subject,bookPrice)
        bookList.append(obj)
    searchId = int(input().strip())
    ob = Library("deepa",bookList)
    x = ob.findSubjectWiseBooks()
    y = ob.checkBookCatergoryByPrice(searchId)
    for key,value in x.items():
        print(key," ",value)
    print(y)
