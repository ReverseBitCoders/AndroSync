#ifndef ANDROSYNCSERVER_H
#define ANDROSYNCSERVER_H

#include <QMainWindow>

namespace Ui {
    class AndroSyncServer;
}

class AndroSyncServer : public QMainWindow
{
    Q_OBJECT

public:
    explicit AndroSyncServer(QWidget *parent = 0);
    ~AndroSyncServer();

private:
    Ui::AndroSyncServer *ui;
};

#endif // ANDROSYNCSERVER_H
