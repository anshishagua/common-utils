
input = open("/Users/xiaoli/Downloads/compare_result_details_1126.csv")
output = open("/Users/xiaoli/Downloads/old_creative_ids.csv", "w")

for line in input:
	creative_id = line.split(",")[0]

	output.write(creative_id + "\n")

input.close()
output.close()