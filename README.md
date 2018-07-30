# RemoveOld
This program is to manager backup files.
Este programa é para gerir arquivos de backup.

The Config.java is the main progran to management the configurations, this file has:
O Config.java é o programa main que gere as configuraçoes, um ficheiro texto que contem:
-nome do backup; / backup name;
-caminho do backup; / backup path;
-formato; format;
-quantidade de arquivos de devem ser mantidos. amount of files should be kept.


Por exemplo, um backup gera estes ficheiros:

    cmfull_AACMA_040001_20150628.tar.gz
    cmfull_AACMA_040001_20150629.tar.gz
    cmfull_AACMA_040001_20150630.tar.gz
    cmfull_AACMA_040001_20150701.tar.gz

E queremos manter apenas os 2 ultimos...

nome do backup: BackACCCM
caminhoh: /backup/acm
formato: cmfull_AACMA_ (o sistema irá analizar o nome para distinguir outros ficheiros na mesma pasta)
quantidade: 2

O programa rmold.java lê este ficheiro e deve remover os ficheiros mais antigos.
no exemplo deixando somente estes:

    cmfull_AACMA_040001_20150630.tar.gz
    cmfull_AACMA_040001_20150701.tar.gz

Executando no Linux:

java -jar rmold.jar > /home/admin/ControlFile/logs/Log_`date "+%Y-%m-%d_%T"`.log
