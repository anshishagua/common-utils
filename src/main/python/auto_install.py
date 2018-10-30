import paramiko
import urllib2
import config
import json


def download_file(url, path):
    f = urllib2.urlopen(url)
    print 'start to download'
    data = f.read()
    print 'start to write to file'

    with open(path, 'wb') as dest:
        dest.write(data)


def check_ssh_connections(cluster_hosts):
    for src in cluster_hosts:
        ssh_client = paramiko.SSHClient()
        ssh_client.set_missing_host_key_policy(paramiko.AutoAddPolicy())
        try:
            ssh_client.connect(hostname=src, username='xiaoli')
        except:
            return False, "Failed to ssh to host:%s" % (src)

        """
        for dest in hosts:
            stdin, stdout, stderr = ssh_client.exec_command("ssh %s@%s" % ("xiaoli", dest))

            error_message = stderr.read()
            output_message = stdout.read()

            print output_message

            if error_message != "":
                return False, "Failed to ssh from host:%s to host:%s" % (src, dest)

        """

    return True, ""


if __name__ == '__main__':
    hosts = ['localhost']

    #status, message = check_ssh_connections(hosts)

    #print status
    #print message
    url = "http://apache.website-solution.net/hadoop/common/hadoop-2.8.5/hadoop-2.8.5-src.tar.gz"
    #download_file(url, "/tmp/aaa.txt")

    config = {}

    json_file = "/Users/xiaoli/IdeaProjects/common-utils/src/main/resources/config.json"
    json_string = ""
    with open(json_file) as f:
        json_string += f.read() + " "

    config = json.loads(json_string)

    a = int
    b = float
    c = str
    d = bool
    hadoop_version = config.get("hadoop", {}).get("version")
    print hadoop_version