import PyPDF2
import sys

input1 = input()
input2 = input()
def pdf_combiner(input1,input2):
	merger = PyPDF2.PdfFileMerger()

	merger.append(input1)
	merger.append(input2)

	merger.write('Combined.pdf')	

pdf_combiner(inputs)
