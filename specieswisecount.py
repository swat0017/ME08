from pandas import read_excel #importing the read_excel function from pandas package
sheet_name1 = 'Protected Species'#sheet name of the xlsx file
file_name1 = 'protected-species-in-fire-affected-areas-20Jan.xlsx'# the name of xlsx file
protected_species_df = read_excel(file_name1, sheet_name1)
print(protected_species_df.tail())
print(protected_species_df.head())
print(protected_species_df)
protected_species_df1= protected_species_df[46:]
print(protected_species_df1)
for col in protected_species_df1.columns: 
    print(col)
protected_species_df1 = protected_species_df1[['Unnamed: 5','Unnamed: 6','Unnamed: 8']]
print(protected_species_df1.head())
protected_species_df1=protected_species_df1.rename(columns = {'Unnamed: 5': 'Type', 'Unnamed: 6': 'EPBC Act listed Threatened Status', 'Unnamed: 8':'Range states and territories ' }, inplace = False)
print(protected_species_df1)
protected_species_df1.drop(protected_species_df1.loc[protected_species_df1['Type']=='Plant'].index, inplace=True)
print(protected_species_df1)
count1 = 0
#for index, row in protected_species_df1.iterrows():
#    if protected_species_df1['Type'] == "Mammal":
#        if protected_species_df1['EPBC Act listed Threatened Status'] == 'Endangered':
 #           count1 +=1
#print(count1)                                                                                   
#print(len(protected_species_df1[protected_species_df1['Type'] == 'Mammal']and protected_species_df1[protected_species_df1['EPBC Act listed Threatened Status'] == 'Endangered']))

condition1 = (protected_species_df1['Type'] == "Mammal") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Endangered')
count1 = condition1.sum()
print(count1)

condition2 = (protected_species_df1['Type'] == "Mammal") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Critically Endangered')
count2 = condition2.sum()
print(count2)

condition3 = (protected_species_df1['Type'] == "Mammal") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Vulnerable')
count3 = condition3.sum()
print(count3)

condition4 = (protected_species_df1['Type'] == "Mammal") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Listed Migration Only')
count4 = condition4.sum()
print(count4)

condition5 = (protected_species_df1['Type'] == "Bird") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Critically Endangered')
count5 = condition5.sum()
print(count5)

condition6 = (protected_species_df1['Type'] == "Bird") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Vulnerable')
count6 = condition6.sum()
print(count6)

condition7 = (protected_species_df1['Type'] == "Bird") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Endangered')
count7 = condition7.sum()
print(count7)

condition8 = (protected_species_df1['Type'] == "Bird") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Listed Migration Only')
count8 = condition8.sum()
print(count8)

condition9 = (protected_species_df1['Type'] == "Fish") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Critically Endangered')
count9 = condition9.sum()
print(count9)

condition10 = (protected_species_df1['Type'] == "Fish") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Vulnerable')
count10 = condition10.sum()
print(count10)

condition11 = (protected_species_df1['Type'] == "Fish") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Endangered')
count11 = condition11.sum()
print(count11)

condition12 = (protected_species_df1['Type'] == "Fish") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Listed Migration Only')
count12 = condition12.sum()
print(count12)

condition13 = (protected_species_df1['Type'] == "Frog") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Critically Endangered')
count13 = condition13.sum()
print(count13)

condition14 = (protected_species_df1['Type'] == "Frog") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Vulnerable')
count14 = condition14.sum()
print(count14)

condition15 = (protected_species_df1['Type'] == "Frog") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Endangered')
count15 = condition15.sum()
print(count15)

condition16 = (protected_species_df1['Type'] == "Frog") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Listed Migration Only')
count16 = condition16.sum()
print(count16)

condition17 = (protected_species_df1['Type'] == "Insect") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Critically Endangered')
count17 = condition17.sum()
print(count9)

condition18 = (protected_species_df1['Type'] == "Insect") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Vulnerable')
count18 = condition18.sum()
print(count18)

condition19 = (protected_species_df1['Type'] == "Insect") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Endangered')
count19 = condition19.sum()
print(count19)

condition20 = (protected_species_df1['Type'] == "Insect") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Listed Migration Only')
count20 = condition20.sum()
print(count20)

condition21 = (protected_species_df1['Type'] == "Reptile") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Critically Endangered')
count21 = condition21.sum()
print(count9)

condition22 = (protected_species_df1['Type'] == "Reptile") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Vulnerable')
count22 = condition22.sum()
print(count22)

condition23 = (protected_species_df1['Type'] == "Reptile") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Endangered')
count23 = condition23.sum()
print(count23)

condition24 = (protected_species_df1['Type'] == "Reptile") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Listed Migration Only')
count24 = condition24.sum()
print(count24)

condition25 = (protected_species_df1['Type'] == "Spider") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Critically Endangered')
count25 = condition25.sum()
print(count25)

condition26 = (protected_species_df1['Type'] == "Spider") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Vulnerable')
count26 = condition26.sum()
print(count26)

condition27 = (protected_species_df1['Type'] == "Spider") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Endangered')
count27 = condition27.sum()
print(count27)

condition28 = (protected_species_df1['Type'] == "Spider") & (protected_species_df1['EPBC Act listed Threatened Status'] == 'Listed Migration Only')
count28 = condition28.sum()
print(count28)

count29= count2+count5+count9+count13+count17+count21+count25
count30= count3+count6+count10+count14+count18+count22+count26
count31= count1+count7+count11+count15+count19+count23+count27
count32= count4+count8+count12+count16+count20+count24+count28

print(count29)
print(count30)
print(count31)
print(count32)
