


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
protected_species_df1.to_excel("Protected_species.xlsx")









     