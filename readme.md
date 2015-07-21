#Denkmalliste Köln

Dieser Service liest von den Offenen Daten der Stadt Köln die [Denkmalliste](http://www.offenedaten-koeln.de/dataset/denkmalliste-stadt-koeln).

Es sind zwei Implementierungen vorgesehen:
- Auslesen der csv-Datei (AskForDenkmallisteKoelnCsv.java)
- Auslesen der json-Struktur (AskForDenkmallisteKoelnJson.java)

##Auslesen der csv-Datei

Die csv Datei hat den Vorteil, dass alle Daten auf einen Schwung eingelesen werden können. Allerdings bricht der Import ab. Vermutlich sind an der Stelle die Daten nicht integer. 

##Auslesen der json-Struktur

Der Service der offenen Daten Köln erlaubt nur 100 Datensätze an einem Stück zurückzuliefern. Um alle Daten auszulesen muss über die Datensätze iteriert werden.