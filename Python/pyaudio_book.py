import pyttsx3
import PyPDF2 as pdf

# Speech Engine Initialization
engine = pyttsx3.init()
speaker = engine.getProperty('voice')
engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Speech\\Voices\\Tokens\\TTS_MS_EN-US_ZIRA_11.0') # Setting voice property
def speak(speech):
	engine.say(speech)
	engine.runAndWait()
# ---------------------------------------------- #

# User Input's
bookNameInput = input("Enter book name: ")
bookName = bookNameInput + ".pdf"
pageStart = int(input("Enter a page to start from: "))

# Opening/Reading PDF
pdfBook = open(bookName, 'rb')
reader = pdf.PdfFileReader(pdfBook)
pages = reader.numPages # To get the number of pages


for i in range(pageStart, pages+1):
	page = reader.getPage(pageStart)
	texts = page.extractText()
	speak(texts)
