import random
import string


def gen_basic_info():
	num_records = 100000

	out = open("/Users/xiaoli/IdeaProjects/common-utils/src/main/resources/customer.csv", "w")

	lines = []

	#id, name, age
	for i in range(num_records):
		id = long(i)
		name = ''.join(random.sample(string.ascii_letters + string.digits, 8))
		age = random.randint(10, 80)

		lines.append("%s,%s,%s\n" % (id, name, age))

		if len(lines) == 10000:
			print "write file"
			out.writelines(lines)
			lines = []

	out.close()


def gen_accounts():
	out = open("/Users/xiaoli/IdeaProjects/common-utils/src/main/resources/accounts.csv", "w")

	lines = []

	#id, user_id
	num_records = 100000
	for i in range(num_records):
		account_id = long(i)
		user_id = random.randint(0, 10000000 - 1)

		lines.append("%s,%s\n" % (account_id, user_id))

		if len(lines) == 10000:
			print "write file"
			out.writelines(lines)
			lines = []

	out.close()


def gen_transactions():
	out = open("/Users/xiaoli/IdeaProjects/common-utils/src/main/resources/transactions.csv", "w")

	lines = []

	#account_id, amount, time
	num_records = 100000
	for i in range(num_records):
		account_id = random.randint(0, 100000)
		amount = random.random() * 10000.00 + 1

		year = random.randint(2016, 2018)
		month = random.randint(1, 12)
		day = random.randint(1, 30)

		if month < 10:
			month = "0" + str(month)
		if day < 10:
			day = "0" + str(day)

		time = "%s-%s-%s" % (year, month, day)

		lines.append("%s,%.2f,%s\n" % (account_id, amount, time))

		if len(lines) == 10000:
			print "write file"
			out.writelines(lines)
			lines = []

	out.close()


gen_basic_info()
gen_accounts()
gen_transactions()
