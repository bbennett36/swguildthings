/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dto.Audit;

/**
 *
 * @author apprentice
 */
public interface AuditDaoInterface {
    
    public Audit createNew(Audit audit);
    public int getNextId();
    
}
