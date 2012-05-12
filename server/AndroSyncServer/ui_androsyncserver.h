/********************************************************************************
** Form generated from reading UI file 'androsyncserver.ui'
**
** Created: Sat May 12 19:20:00 2012
**      by: Qt User Interface Compiler version 4.8.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_ANDROSYNCSERVER_H
#define UI_ANDROSYNCSERVER_H

#include <QtCore/QVariant>
#include <QtGui/QAction>
#include <QtGui/QApplication>
#include <QtGui/QButtonGroup>
#include <QtGui/QDockWidget>
#include <QtGui/QFormLayout>
#include <QtGui/QGridLayout>
#include <QtGui/QHBoxLayout>
#include <QtGui/QHeaderView>
#include <QtGui/QLabel>
#include <QtGui/QMainWindow>
#include <QtGui/QMenuBar>
#include <QtGui/QPushButton>
#include <QtGui/QStackedWidget>
#include <QtGui/QStatusBar>
#include <QtGui/QTabWidget>
#include <QtGui/QTableView>
#include <QtGui/QToolBar>
#include <QtGui/QVBoxLayout>
#include <QtGui/QWidget>

QT_BEGIN_NAMESPACE

class Ui_AndroSyncServer
{
public:
    QWidget *centralWidget;
    QVBoxLayout *verticalLayout_2;
    QLabel *lblTitle;
    QStackedWidget *stackedPages;
    QWidget *page_Home;
    QVBoxLayout *verticalLayout;
    QGridLayout *gridLayout;
    QPushButton *pushBt_Contacts;
    QPushButton *pushBt_Messages;
    QPushButton *pushBt_Logs;
    QPushButton *pushBt_Notes;
    QPushButton *pushBt_Multimedia;
    QPushButton *pushBt_Settings;
    QWidget *page_Contacts;
    QHBoxLayout *horizontalLayout_2;
    QTableView *tableViewContacts;
    QWidget *page_Messages;
    QHBoxLayout *horizontalLayout_3;
    QTabWidget *tabMessages;
    QWidget *Inbox;
    QHBoxLayout *horizontalLayout;
    QTableView *tableViewInbox;
    QWidget *Outbox;
    QHBoxLayout *horizontalLayout_4;
    QTableView *tableViewOutbox;
    QWidget *Drafts;
    QHBoxLayout *horizontalLayout_5;
    QTableView *tableViewDrafts;
    QWidget *page_callLogs;
    QVBoxLayout *verticalLayout_3;
    QTabWidget *tabLogs;
    QWidget *tabIncoming;
    QHBoxLayout *horizontalLayout_6;
    QTableView *tableViewIncoming;
    QWidget *tabOutgoing;
    QHBoxLayout *horizontalLayout_7;
    QTableView *tableViewOutgoing;
    QWidget *tab;
    QHBoxLayout *horizontalLayout_8;
    QTableView *tableViewMissed;
    QMenuBar *menuBar;
    QToolBar *mainToolBar;
    QStatusBar *statusBar;
    QDockWidget *dockWidget;
    QWidget *dockSideBar;
    QFormLayout *formLayout;
    QPushButton *pushBt_dock_Multimedia;
    QPushButton *pushBt_dock_Notes;
    QPushButton *pushBt_dock_Messages;
    QPushButton *pushBt_dock_Logs;
    QPushButton *pushBt_dock_Contacts;
    QPushButton *pushBt_dock_Home;

    void setupUi(QMainWindow *AndroSyncServer)
    {
        if (AndroSyncServer->objectName().isEmpty())
            AndroSyncServer->setObjectName(QString::fromUtf8("AndroSyncServer"));
        AndroSyncServer->resize(681, 450);
        AndroSyncServer->setMinimumSize(QSize(681, 450));
        AndroSyncServer->setMaximumSize(QSize(681, 450));
        AndroSyncServer->setAutoFillBackground(false);
        centralWidget = new QWidget(AndroSyncServer);
        centralWidget->setObjectName(QString::fromUtf8("centralWidget"));
        verticalLayout_2 = new QVBoxLayout(centralWidget);
        verticalLayout_2->setSpacing(6);
        verticalLayout_2->setContentsMargins(11, 11, 11, 11);
        verticalLayout_2->setObjectName(QString::fromUtf8("verticalLayout_2"));
        lblTitle = new QLabel(centralWidget);
        lblTitle->setObjectName(QString::fromUtf8("lblTitle"));
        lblTitle->setAlignment(Qt::AlignCenter);

        verticalLayout_2->addWidget(lblTitle);

        stackedPages = new QStackedWidget(centralWidget);
        stackedPages->setObjectName(QString::fromUtf8("stackedPages"));
        page_Home = new QWidget();
        page_Home->setObjectName(QString::fromUtf8("page_Home"));
        verticalLayout = new QVBoxLayout(page_Home);
        verticalLayout->setSpacing(6);
        verticalLayout->setContentsMargins(11, 11, 11, 11);
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        gridLayout = new QGridLayout();
        gridLayout->setSpacing(6);
        gridLayout->setObjectName(QString::fromUtf8("gridLayout"));
        pushBt_Contacts = new QPushButton(page_Home);
        pushBt_Contacts->setObjectName(QString::fromUtf8("pushBt_Contacts"));
        pushBt_Contacts->setMinimumSize(QSize(68, 68));
        pushBt_Contacts->setMaximumSize(QSize(68, 68));
        QIcon icon;
        icon.addFile(QString::fromUtf8(":/icons/icons/contacts_64.png"), QSize(), QIcon::Normal, QIcon::Off);
        pushBt_Contacts->setIcon(icon);
        pushBt_Contacts->setIconSize(QSize(64, 64));

        gridLayout->addWidget(pushBt_Contacts, 0, 0, 1, 1);

        pushBt_Messages = new QPushButton(page_Home);
        pushBt_Messages->setObjectName(QString::fromUtf8("pushBt_Messages"));
        pushBt_Messages->setMinimumSize(QSize(68, 68));
        pushBt_Messages->setMaximumSize(QSize(68, 68));
        QIcon icon1;
        icon1.addFile(QString::fromUtf8(":/icons/icons/messages_64.png"), QSize(), QIcon::Normal, QIcon::Off);
        pushBt_Messages->setIcon(icon1);
        pushBt_Messages->setIconSize(QSize(64, 64));
        pushBt_Messages->setFlat(false);

        gridLayout->addWidget(pushBt_Messages, 0, 1, 1, 1);

        pushBt_Logs = new QPushButton(page_Home);
        pushBt_Logs->setObjectName(QString::fromUtf8("pushBt_Logs"));
        pushBt_Logs->setMinimumSize(QSize(68, 68));
        pushBt_Logs->setMaximumSize(QSize(68, 68));
        QIcon icon2;
        icon2.addFile(QString::fromUtf8(":/icons/icons/logs_64.png"), QSize(), QIcon::Normal, QIcon::Off);
        pushBt_Logs->setIcon(icon2);
        pushBt_Logs->setIconSize(QSize(64, 64));

        gridLayout->addWidget(pushBt_Logs, 0, 2, 1, 1);

        pushBt_Notes = new QPushButton(page_Home);
        pushBt_Notes->setObjectName(QString::fromUtf8("pushBt_Notes"));
        pushBt_Notes->setMinimumSize(QSize(68, 68));
        pushBt_Notes->setMaximumSize(QSize(68, 68));
        QIcon icon3;
        icon3.addFile(QString::fromUtf8(":/icons/icons/notes_64.png"), QSize(), QIcon::Normal, QIcon::Off);
        pushBt_Notes->setIcon(icon3);
        pushBt_Notes->setIconSize(QSize(64, 64));

        gridLayout->addWidget(pushBt_Notes, 1, 0, 1, 1);

        pushBt_Multimedia = new QPushButton(page_Home);
        pushBt_Multimedia->setObjectName(QString::fromUtf8("pushBt_Multimedia"));
        pushBt_Multimedia->setMinimumSize(QSize(68, 68));
        pushBt_Multimedia->setMaximumSize(QSize(68, 68));
        QIcon icon4;
        icon4.addFile(QString::fromUtf8(":/icons/icons/multimedia.png"), QSize(), QIcon::Normal, QIcon::Off);
        pushBt_Multimedia->setIcon(icon4);
        pushBt_Multimedia->setIconSize(QSize(64, 64));

        gridLayout->addWidget(pushBt_Multimedia, 1, 1, 1, 1);

        pushBt_Settings = new QPushButton(page_Home);
        pushBt_Settings->setObjectName(QString::fromUtf8("pushBt_Settings"));
        pushBt_Settings->setMinimumSize(QSize(68, 68));
        pushBt_Settings->setMaximumSize(QSize(68, 68));
        QIcon icon5;
        icon5.addFile(QString::fromUtf8(":/icons/icons/Settings_64.png"), QSize(), QIcon::Normal, QIcon::Off);
        pushBt_Settings->setIcon(icon5);
        pushBt_Settings->setIconSize(QSize(64, 64));

        gridLayout->addWidget(pushBt_Settings, 1, 2, 1, 1);


        verticalLayout->addLayout(gridLayout);

        stackedPages->addWidget(page_Home);
        page_Contacts = new QWidget();
        page_Contacts->setObjectName(QString::fromUtf8("page_Contacts"));
        horizontalLayout_2 = new QHBoxLayout(page_Contacts);
        horizontalLayout_2->setSpacing(6);
        horizontalLayout_2->setContentsMargins(11, 11, 11, 11);
        horizontalLayout_2->setObjectName(QString::fromUtf8("horizontalLayout_2"));
        tableViewContacts = new QTableView(page_Contacts);
        tableViewContacts->setObjectName(QString::fromUtf8("tableViewContacts"));

        horizontalLayout_2->addWidget(tableViewContacts);

        stackedPages->addWidget(page_Contacts);
        page_Messages = new QWidget();
        page_Messages->setObjectName(QString::fromUtf8("page_Messages"));
        horizontalLayout_3 = new QHBoxLayout(page_Messages);
        horizontalLayout_3->setSpacing(6);
        horizontalLayout_3->setContentsMargins(11, 11, 11, 11);
        horizontalLayout_3->setObjectName(QString::fromUtf8("horizontalLayout_3"));
        tabMessages = new QTabWidget(page_Messages);
        tabMessages->setObjectName(QString::fromUtf8("tabMessages"));
        tabMessages->setTabPosition(QTabWidget::West);
        Inbox = new QWidget();
        Inbox->setObjectName(QString::fromUtf8("Inbox"));
        horizontalLayout = new QHBoxLayout(Inbox);
        horizontalLayout->setSpacing(6);
        horizontalLayout->setContentsMargins(11, 11, 11, 11);
        horizontalLayout->setObjectName(QString::fromUtf8("horizontalLayout"));
        tableViewInbox = new QTableView(Inbox);
        tableViewInbox->setObjectName(QString::fromUtf8("tableViewInbox"));

        horizontalLayout->addWidget(tableViewInbox);

        tabMessages->addTab(Inbox, QString());
        Outbox = new QWidget();
        Outbox->setObjectName(QString::fromUtf8("Outbox"));
        horizontalLayout_4 = new QHBoxLayout(Outbox);
        horizontalLayout_4->setSpacing(6);
        horizontalLayout_4->setContentsMargins(11, 11, 11, 11);
        horizontalLayout_4->setObjectName(QString::fromUtf8("horizontalLayout_4"));
        tableViewOutbox = new QTableView(Outbox);
        tableViewOutbox->setObjectName(QString::fromUtf8("tableViewOutbox"));

        horizontalLayout_4->addWidget(tableViewOutbox);

        tabMessages->addTab(Outbox, QString());
        Drafts = new QWidget();
        Drafts->setObjectName(QString::fromUtf8("Drafts"));
        horizontalLayout_5 = new QHBoxLayout(Drafts);
        horizontalLayout_5->setSpacing(6);
        horizontalLayout_5->setContentsMargins(11, 11, 11, 11);
        horizontalLayout_5->setObjectName(QString::fromUtf8("horizontalLayout_5"));
        tableViewDrafts = new QTableView(Drafts);
        tableViewDrafts->setObjectName(QString::fromUtf8("tableViewDrafts"));

        horizontalLayout_5->addWidget(tableViewDrafts);

        tabMessages->addTab(Drafts, QString());

        horizontalLayout_3->addWidget(tabMessages);

        stackedPages->addWidget(page_Messages);
        page_callLogs = new QWidget();
        page_callLogs->setObjectName(QString::fromUtf8("page_callLogs"));
        verticalLayout_3 = new QVBoxLayout(page_callLogs);
        verticalLayout_3->setSpacing(6);
        verticalLayout_3->setContentsMargins(11, 11, 11, 11);
        verticalLayout_3->setObjectName(QString::fromUtf8("verticalLayout_3"));
        tabLogs = new QTabWidget(page_callLogs);
        tabLogs->setObjectName(QString::fromUtf8("tabLogs"));
        tabLogs->setTabPosition(QTabWidget::West);
        tabIncoming = new QWidget();
        tabIncoming->setObjectName(QString::fromUtf8("tabIncoming"));
        horizontalLayout_6 = new QHBoxLayout(tabIncoming);
        horizontalLayout_6->setSpacing(6);
        horizontalLayout_6->setContentsMargins(11, 11, 11, 11);
        horizontalLayout_6->setObjectName(QString::fromUtf8("horizontalLayout_6"));
        tableViewIncoming = new QTableView(tabIncoming);
        tableViewIncoming->setObjectName(QString::fromUtf8("tableViewIncoming"));

        horizontalLayout_6->addWidget(tableViewIncoming);

        tabLogs->addTab(tabIncoming, QString());
        tabOutgoing = new QWidget();
        tabOutgoing->setObjectName(QString::fromUtf8("tabOutgoing"));
        horizontalLayout_7 = new QHBoxLayout(tabOutgoing);
        horizontalLayout_7->setSpacing(6);
        horizontalLayout_7->setContentsMargins(11, 11, 11, 11);
        horizontalLayout_7->setObjectName(QString::fromUtf8("horizontalLayout_7"));
        tableViewOutgoing = new QTableView(tabOutgoing);
        tableViewOutgoing->setObjectName(QString::fromUtf8("tableViewOutgoing"));

        horizontalLayout_7->addWidget(tableViewOutgoing);

        tabLogs->addTab(tabOutgoing, QString());
        tab = new QWidget();
        tab->setObjectName(QString::fromUtf8("tab"));
        horizontalLayout_8 = new QHBoxLayout(tab);
        horizontalLayout_8->setSpacing(6);
        horizontalLayout_8->setContentsMargins(11, 11, 11, 11);
        horizontalLayout_8->setObjectName(QString::fromUtf8("horizontalLayout_8"));
        tableViewMissed = new QTableView(tab);
        tableViewMissed->setObjectName(QString::fromUtf8("tableViewMissed"));

        horizontalLayout_8->addWidget(tableViewMissed);

        tabLogs->addTab(tab, QString());

        verticalLayout_3->addWidget(tabLogs);

        stackedPages->addWidget(page_callLogs);

        verticalLayout_2->addWidget(stackedPages);

        AndroSyncServer->setCentralWidget(centralWidget);
        menuBar = new QMenuBar(AndroSyncServer);
        menuBar->setObjectName(QString::fromUtf8("menuBar"));
        menuBar->setGeometry(QRect(0, 0, 681, 23));
        AndroSyncServer->setMenuBar(menuBar);
        mainToolBar = new QToolBar(AndroSyncServer);
        mainToolBar->setObjectName(QString::fromUtf8("mainToolBar"));
        AndroSyncServer->addToolBar(Qt::TopToolBarArea, mainToolBar);
        statusBar = new QStatusBar(AndroSyncServer);
        statusBar->setObjectName(QString::fromUtf8("statusBar"));
        AndroSyncServer->setStatusBar(statusBar);
        dockWidget = new QDockWidget(AndroSyncServer);
        dockWidget->setObjectName(QString::fromUtf8("dockWidget"));
        QSizePolicy sizePolicy(QSizePolicy::Preferred, QSizePolicy::Preferred);
        sizePolicy.setHorizontalStretch(0);
        sizePolicy.setVerticalStretch(0);
        sizePolicy.setHeightForWidth(dockWidget->sizePolicy().hasHeightForWidth());
        dockWidget->setSizePolicy(sizePolicy);
        dockWidget->setMinimumSize(QSize(80, 390));
        dockWidget->setMaximumSize(QSize(80, 390));
        dockWidget->setFeatures(QDockWidget::NoDockWidgetFeatures);
        dockWidget->setAllowedAreas(Qt::AllDockWidgetAreas);
        dockSideBar = new QWidget();
        dockSideBar->setObjectName(QString::fromUtf8("dockSideBar"));
        formLayout = new QFormLayout(dockSideBar);
        formLayout->setSpacing(6);
        formLayout->setContentsMargins(11, 11, 11, 11);
        formLayout->setObjectName(QString::fromUtf8("formLayout"));
        formLayout->setFieldGrowthPolicy(QFormLayout::ExpandingFieldsGrow);
        pushBt_dock_Multimedia = new QPushButton(dockSideBar);
        pushBt_dock_Multimedia->setObjectName(QString::fromUtf8("pushBt_dock_Multimedia"));
        pushBt_dock_Multimedia->setMinimumSize(QSize(48, 48));
        pushBt_dock_Multimedia->setMaximumSize(QSize(48, 48));
        pushBt_dock_Multimedia->setIcon(icon4);
        pushBt_dock_Multimedia->setIconSize(QSize(48, 48));

        formLayout->setWidget(16, QFormLayout::FieldRole, pushBt_dock_Multimedia);

        pushBt_dock_Notes = new QPushButton(dockSideBar);
        pushBt_dock_Notes->setObjectName(QString::fromUtf8("pushBt_dock_Notes"));
        pushBt_dock_Notes->setMinimumSize(QSize(48, 48));
        pushBt_dock_Notes->setMaximumSize(QSize(48, 48));
        pushBt_dock_Notes->setIcon(icon3);
        pushBt_dock_Notes->setIconSize(QSize(48, 48));

        formLayout->setWidget(13, QFormLayout::FieldRole, pushBt_dock_Notes);

        pushBt_dock_Messages = new QPushButton(dockSideBar);
        pushBt_dock_Messages->setObjectName(QString::fromUtf8("pushBt_dock_Messages"));
        pushBt_dock_Messages->setMinimumSize(QSize(48, 48));
        pushBt_dock_Messages->setMaximumSize(QSize(48, 48));
        pushBt_dock_Messages->setIcon(icon1);
        pushBt_dock_Messages->setIconSize(QSize(48, 48));
        pushBt_dock_Messages->setCheckable(false);
        pushBt_dock_Messages->setFlat(false);

        formLayout->setWidget(11, QFormLayout::FieldRole, pushBt_dock_Messages);

        pushBt_dock_Logs = new QPushButton(dockSideBar);
        pushBt_dock_Logs->setObjectName(QString::fromUtf8("pushBt_dock_Logs"));
        pushBt_dock_Logs->setMinimumSize(QSize(48, 48));
        pushBt_dock_Logs->setMaximumSize(QSize(48, 48));
        pushBt_dock_Logs->setIcon(icon2);
        pushBt_dock_Logs->setIconSize(QSize(48, 48));

        formLayout->setWidget(12, QFormLayout::FieldRole, pushBt_dock_Logs);

        pushBt_dock_Contacts = new QPushButton(dockSideBar);
        pushBt_dock_Contacts->setObjectName(QString::fromUtf8("pushBt_dock_Contacts"));
        pushBt_dock_Contacts->setMinimumSize(QSize(48, 48));
        pushBt_dock_Contacts->setMaximumSize(QSize(48, 48));
        pushBt_dock_Contacts->setIcon(icon);
        pushBt_dock_Contacts->setIconSize(QSize(48, 48));

        formLayout->setWidget(9, QFormLayout::FieldRole, pushBt_dock_Contacts);

        pushBt_dock_Home = new QPushButton(dockSideBar);
        pushBt_dock_Home->setObjectName(QString::fromUtf8("pushBt_dock_Home"));
        pushBt_dock_Home->setMinimumSize(QSize(48, 48));
        pushBt_dock_Home->setMaximumSize(QSize(48, 48));
        QIcon icon6;
        icon6.addFile(QString::fromUtf8(":/icons/icons/home_64.png"), QSize(), QIcon::Normal, QIcon::Off);
        pushBt_dock_Home->setIcon(icon6);
        pushBt_dock_Home->setIconSize(QSize(48, 48));

        formLayout->setWidget(8, QFormLayout::FieldRole, pushBt_dock_Home);

        dockWidget->setWidget(dockSideBar);
        AndroSyncServer->addDockWidget(static_cast<Qt::DockWidgetArea>(1), dockWidget);

        retranslateUi(AndroSyncServer);

        stackedPages->setCurrentIndex(0);
        tabMessages->setCurrentIndex(0);
        tabLogs->setCurrentIndex(0);


        QMetaObject::connectSlotsByName(AndroSyncServer);
    } // setupUi

    void retranslateUi(QMainWindow *AndroSyncServer)
    {
        AndroSyncServer->setWindowTitle(QApplication::translate("AndroSyncServer", "AndroSyncServer", 0, QApplication::UnicodeUTF8));
        lblTitle->setText(QApplication::translate("AndroSyncServer", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"
"p, li { white-space: pre-wrap; }\n"
"</style></head><body style=\" font-family:'Ubuntu'; font-size:11pt; font-weight:400; font-style:normal;\">\n"
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><h2>AndroSync</h2></p></body></html>", 0, QApplication::UnicodeUTF8));
        pushBt_Contacts->setText(QString());
        pushBt_Messages->setText(QString());
        pushBt_Logs->setText(QString());
        pushBt_Notes->setText(QString());
        pushBt_Multimedia->setText(QString());
        pushBt_Settings->setText(QString());
        tabMessages->setTabText(tabMessages->indexOf(Inbox), QApplication::translate("AndroSyncServer", "Inbox", 0, QApplication::UnicodeUTF8));
        tabMessages->setTabText(tabMessages->indexOf(Outbox), QApplication::translate("AndroSyncServer", "Outbox", 0, QApplication::UnicodeUTF8));
        tabMessages->setTabText(tabMessages->indexOf(Drafts), QApplication::translate("AndroSyncServer", "Drafts", 0, QApplication::UnicodeUTF8));
        tabLogs->setTabText(tabLogs->indexOf(tabIncoming), QApplication::translate("AndroSyncServer", "Incoming", 0, QApplication::UnicodeUTF8));
        tabLogs->setTabText(tabLogs->indexOf(tabOutgoing), QApplication::translate("AndroSyncServer", "Outgoing", 0, QApplication::UnicodeUTF8));
        tabLogs->setTabText(tabLogs->indexOf(tab), QApplication::translate("AndroSyncServer", "Missed", 0, QApplication::UnicodeUTF8));
        pushBt_dock_Multimedia->setText(QString());
        pushBt_dock_Notes->setText(QString());
        pushBt_dock_Messages->setText(QString());
        pushBt_dock_Messages->setShortcut(QString());
        pushBt_dock_Logs->setText(QString());
        pushBt_dock_Contacts->setText(QString());
        pushBt_dock_Home->setText(QString());
    } // retranslateUi

};

namespace Ui {
    class AndroSyncServer: public Ui_AndroSyncServer {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_ANDROSYNCSERVER_H
