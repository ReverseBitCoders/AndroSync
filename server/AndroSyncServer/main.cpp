#include <QtGui/QApplication>
#include "androsyncserver.h"

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    AndroSyncServer w;
    w.show();

    return a.exec();
}
